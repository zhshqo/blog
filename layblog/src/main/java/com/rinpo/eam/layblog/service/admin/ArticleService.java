package com.rinpo.eam.layblog.service.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.rinpo.eam.layblog.dao.TArticleMapper;
import com.rinpo.eam.layblog.model.TArticle;
import com.rinpo.eam.layblog.model.TArticleExample;
import com.rinpo.eam.layblog.model.TTag;
import com.rinpo.eam.layblog.model.TTagRefer;
import com.rinpo.eam.layblog.utils.StringUtils;
import com.rinpo.eam.layblog.utils.TokenProccessor;
import com.rinpo.eam.layblog.utils.WebUtils;
import com.rinpo.eam.layblog.vo.Page;
import com.rinpo.eam.layblog.vo.admin.ArticleQueryVo;
import com.rinpo.eam.layblog.vo.admin.ArticleVo;

import cn.hutool.core.util.StrUtil;

@Service
public class ArticleService {

	private final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	@Autowired
    private TArticleMapper articleMapper;
	@Autowired
    private TagService tagService;
	@Autowired
    private TagReferService tagReferService;
	@Autowired
    private CateService cateService;
	
	/**
	 * 保存文章
	 * @param article
	 * @param tagNames
	 * @return
	 */
    public boolean postArticle(TArticle article, String tagNames) {
    	if (StringUtils.isEmpty(tagNames)) {
            throw new RuntimeException("tagName不能为空！");
        }
        String[] tagNameArray = tagNames.split(",");
        try {
        	String articleId = TokenProccessor.getInstance().makeTokenURLSafe();
            article.setId(articleId);
            getSumByFilterContent(article);
            //保存博客
            int savedNum = articleMapper.insertSelective(article);
            if (savedNum == 0) {
                throw new RuntimeException("博文未发布成功...");
            }
            //保存标签tag
            for (String name : Arrays.asList(tagNameArray)) {
                if (tagService.countByName(name) == 0) {
                	//如果数据库中没有该记录则保存
                	TTag tag = new TTag();
                	tag.setName(name);
                    tagService.insert(tag);
                }
                int tagId = tagService.selectId(name);
                //关联文章和标签
                TTagRefer tagRefer = new TTagRefer();
                tagRefer.setReferId(articleId);
                tagRefer.setTagId(tagId);
                tagReferService.insert(tagRefer);
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 更新博文
     * @param article
     * @param tagNames
     * @return
     */
    public boolean updateArticle(TArticle article, String tagNames) {
        String[] tagNameArray = tagNames.split(",");
        try {
            article.setModifyTime(new Date());
            getSumByFilterContent(article);
            //更新博客
            int savedNum = articleMapper.updateByPrimaryKey(article);
            if (savedNum == 0) {
                throw new RuntimeException("博文未更新成功...");
            }
            //先删除标签关联
            tagReferService.deleteByReferId(article.getId());
            //再重新关联标签
            for (String name : Arrays.asList(tagNameArray)) {
                if (tagService.countByName(name) == 0) {
                	//如果数据库中没有该记录则保存
                	TTag tag = new TTag();
                	tag.setName(name);
                    tagService.insert(tag);
                }
                int tagId = tagService.selectId(name);
                //关联文章和标签
                TTagRefer tagRefer = new TTagRefer();
                tagRefer.setReferId(article.getId());
                tagRefer.setTagId(tagId);
                tagReferService.insert(tagRefer);
            }
            
            return true;
        } catch (Exception e) {
            logger.error("发布博文出错，回滚数据...", e);
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 获取文章摘要
     * @param article
     */
    private void getSumByFilterContent(TArticle article) {
        String clearContent = WebUtils.filterHtml(StrUtil.trim(article.getContent()));
        clearContent = StringUtils.trimAllWhitespace(clearContent);
        clearContent = clearContent.substring(0, clearContent.length() < 243 ? clearContent.length() : 243);
        int allStandardLength = clearContent.length();
        int fullAngelLength = StringUtils.fullAngelWords(clearContent);
        int finalLength = allStandardLength - fullAngelLength / 2;
        article.setSummary(clearContent.substring(0, finalLength < 243 ? finalLength : 243));
//        article.setTextContent(clearContent);
    }
    
    /**
     * 分页查询
     * @param articlePage
     * @param articleBo
     * @return
     */
    public Page<ArticleVo> findPagination(ArticleQueryVo articleBo) {
    	TArticleExample example = new TArticleExample();
    	TArticleExample.Criteria criteria = example.createCriteria();
    	if(articleBo.getTitle()!=null&&articleBo.getTitle().trim().length()>0) {
    		criteria.andTitleLike("%"+articleBo.getTitle()+"%");
    	}
    	example.setOrderByClause((articleBo.getSort()==null?"POST_TIME":articleBo.getSort())+" "+(articleBo.getOrder()==null?"ASC":articleBo.getOrder()));
    	
    	//startPage(1, 10)获取第1页，10条内容，默认查询总数count，紧跟着的第一个select方法会被分页
    	com.github.pagehelper.Page<Object> startPage = PageHelper.startPage(articleBo.getPageNo(), articleBo.getPageSize());
        List<TArticle> list = articleMapper.selectByExample(example);
        List<ArticleVo> result = new ArrayList<ArticleVo>();
        for(TArticle article:list) {
        	//查询分类名称
        	ArticleVo vo = new ArticleVo();
        	BeanUtils.copyProperties(article, vo);
        	String cateName = cateService.findNameById(vo.getCateId());
        	if(cateName!=null) {
        		vo.setCateName(cateName);
        	}
        	result.add(vo);
        }
        Page<ArticleVo> articlePage = new Page<ArticleVo>();
        articlePage.setTotalCount((int)startPage.getTotal());
        articlePage.setResult(result);
        return articlePage;
    }
    
    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    public TArticle findOne(String id) {
    	return articleMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    public int delete(String id) {
    	return articleMapper.deleteByPrimaryKey(id);
    }
    
    /**
     * 根据id更新是否开启点赞
     * @param id
     * @param appreciable
     * @return
     */
    public int updateAppreciableById(String id, Boolean appreciable) {
    	TArticle record = new TArticle();
    	record.setId(id);
    	record.setAppreciable(appreciable);
    	return articleMapper.updateByPrimaryKeySelective(record);
    }
    
    /**
     * 根据id更新是否开启评论
     * @param id
     * @param commented
     * @return
     */
    public int updateCommentedById(String id, Boolean commented) {
    	TArticle record = new TArticle();
    	record.setId(id);
    	record.setCommented(commented);
    	return articleMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 浏览数+1
     * @param id
     * @return
     */
    public int updateViewsById(String id) {
    	TArticle article = articleMapper.selectByPrimaryKey(id);
    	Integer newViewsCnt = article.getViewsCnt()+1;
    	article.setViewsCnt(newViewsCnt);
    	return articleMapper.updateByPrimaryKey(article);
    }
    
    /**
     * 根据分类查找文章
     * @param cateId
     * @param limit
     * @return
     */
    public List<TArticle> findArticlesByCateId(Integer cateId, int limit) {
    	TArticleExample example = new TArticleExample();
    	TArticleExample.Criteria criteria = example.createCriteria();
    	criteria.andCateIdEqualTo(cateId);
    	//startPage(1, 10)获取第1页，10条内容，默认查询总数count，紧跟着的第一个select方法会被分页
    	com.github.pagehelper.Page<Object> startPage = PageHelper.startPage(1,limit);
        return articleMapper.selectByExample(example);
    }
    
    /**
     * 获取相似文章
     * @param list
     * @return
     */
    public List<Map<String, Object>> findSimilarArticles(Integer cateId, int limit){
    	List<TArticle> list = findArticlesByCateId(cateId,limit);
    	if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<Map<String, Object>> newListMap = new LinkedList<>();
        for (TArticle article : list) {
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("id", article.getId());
        	map.put("title", article.getTitle());
        	newListMap.add(map);
		}
        return newListMap;
    }
    
    /**
     * 获取前limit条文章
     * @param limit
     * @return
     */
    public List<TArticle> findPageArticles(int pageNum, int pageSize) {
    	//startPage(1, 10)获取第1页，10条内容，默认查询总数count，紧跟着的第一个select方法会被分页
    	com.github.pagehelper.Page<Object> startPage = PageHelper.startPage(pageNum, pageSize);
        return articleMapper.selectByExample(new TArticleExample());
    }
    
    /**
     * 获取前多少文章
     * @param list
     * @return
     */
    public List<Map<String, Object>> findTopArticles(int limit){
    	List<TArticle> list = findPageArticles(1,limit);
    	if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<Map<String, Object>> newListMap = new LinkedList<>();
        for (TArticle article : list) {
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("id", article.getId());
        	map.put("title", article.getTitle());
        	newListMap.add(map);
		}
        return newListMap;
    }
    
    /**
     * 点赞数+1
     * @param articleId
     * @return
     */
    public int updateApproveCntById(String articleId) {
    	TArticle article = articleMapper.selectByPrimaryKey(articleId);
    	Integer newApproveCnt = article.getApproveCnt()+1;
    	article.setApproveCnt(newApproveCnt);
    	return articleMapper.updateByPrimaryKey(article);
    }
    
    /**
     * 查询文章数量
     * @return
     */
    public long count() {
    	return articleMapper.countByExample(new TArticleExample());
    }
}
