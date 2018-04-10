package com.rinpo.eam.layblog.service.frontend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinpo.eam.layblog.model.TCate;
import com.rinpo.eam.layblog.model.TTag;
import com.rinpo.eam.layblog.service.admin.ArticleService;
import com.rinpo.eam.layblog.service.admin.CateService;
import com.rinpo.eam.layblog.service.admin.TagService;
import com.rinpo.eam.layblog.vo.Page;
import com.rinpo.eam.layblog.vo.admin.ArticleQueryVo;
import com.rinpo.eam.layblog.vo.admin.ArticleVo;
import com.rinpo.eam.layblog.vo.frontend.IndexArticleQueryVo;
import com.rinpo.eam.layblog.vo.frontend.IndexArticleVo;
import com.rinpo.eam.layblog.vo.frontend.IndexVo;

@Service
public class IndexService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CateService cateService;
    @Autowired
    private TagService tagService;

    public IndexVo findIndexVo() {
    	
    	IndexVo indexVo = new IndexVo();
    	//博客数量
    	long blogCount = articleService.count();
    	indexVo.setBlogCount(blogCount);
    	//所有的分类
    	List<TCate> cateList = cateService.findAll();
    	indexVo.setCateList(cateList);
    	//所有标签
    	indexVo.setTagList(tagService.findAllTags());
    	
    	//前10篇
    	List<Map<String, Object>>  randomArticles = articleService.findTopArticles(10);
    	indexVo.setRandomArticles(randomArticles);
    	//设置是否是管理员
    	indexVo.setSu(null);
    	
    	return indexVo;
    }

    public IndexArticleVo next(IndexArticleQueryVo indexArticleBo) {
    	//分页查找文章
    	ArticleQueryVo articleQueryBo = new ArticleQueryVo();
    	articleQueryBo.setTitle(indexArticleBo.getTitle());
    	articleQueryBo.setSort(indexArticleBo.getSort());
    	articleQueryBo.setOrder(indexArticleBo.getOrder());
    	articleQueryBo.setPage(indexArticleBo.getPageNo());
    	articleQueryBo.setLimit(indexArticleBo.getPageSize());
    	
    	Page<ArticleVo> nextPage =articleService.findPagination(articleQueryBo);
    	//查找标签
    	Map<String, List<TTag>> articleTags = new HashMap<String, List<TTag>>();
    	for (ArticleVo ele : nextPage.getTResult()) {
    		articleTags.put(ele.getId(), tagService.findTagsByArticleId(ele.getId()));
		}
    	IndexArticleVo indexArticleVo = new IndexArticleVo();
    	indexArticleVo.setPage(nextPage);
    	indexArticleVo.setTags(articleTags);
    	return indexArticleVo;
    }
}
