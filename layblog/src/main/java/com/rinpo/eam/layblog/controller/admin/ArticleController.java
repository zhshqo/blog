package com.rinpo.eam.layblog.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rinpo.eam.layblog.controller.BaseController;
import com.rinpo.eam.layblog.model.TArticle;
import com.rinpo.eam.layblog.model.TCate;
import com.rinpo.eam.layblog.service.admin.ArticleService;
import com.rinpo.eam.layblog.service.admin.CateService;
import com.rinpo.eam.layblog.service.admin.TagReferService;
import com.rinpo.eam.layblog.service.admin.UploadService;
import com.rinpo.eam.layblog.vo.Page;
import com.rinpo.eam.layblog.vo.R;
import com.rinpo.eam.layblog.vo.admin.ArticleQueryVo;
import com.rinpo.eam.layblog.vo.admin.ArticleVo;
import com.rinpo.eam.layblog.vo.layui.table.LayuiTable;

@Controller("adminArticleController")
@RequestMapping("/admin/blog")
public class ArticleController extends BaseController{

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private UploadService uploadService;
    
    @Autowired
    private CateService cateService;
    
    @Autowired
    private TagReferService tagReferService;

    @GetMapping
    public String blog(Model model) {
    	List<TCate> cates = new ArrayList<TCate>();
        TCate cate = new TCate();
        cate.setId(123);
        cate.setName("IT");
        cate.setCnName("计算机");
        cates.add(cate);
        model.addAttribute("cateList", cates);
        return "admin/admin_blog";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/admin_blogs";
    }

    @PostMapping("/list")
    @ResponseBody
    public LayuiTable<ArticleVo> list(ArticleQueryVo articleBo) {
    	//查询文章
    	Page<ArticleVo> articlePage = articleService.findPagination(articleBo);
    	return new LayuiTable<>(articlePage.getTotalCount(), articlePage.getTResult());
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {

    	model.addAttribute("cateList", cateService.findAll());
        model.addAttribute("editArticle", articleService.findOne(id));
        String[] tagArray = tagReferService.findTagNameByReferId(id).toArray(new String[]{});
        String tags = Arrays.toString(tagArray);
        model.addAttribute("articleTags", tags.substring(1, tags.length() - 1));
        return "admin/blog_edit";
    }
    
    @PostMapping("/doEdit")
    @ResponseBody
    public R doEdit(@Valid TArticle article, String tagName, BindingResult result) {
        article.setAuthorId(123);
        articleService.updateArticle(article, tagName);
        return R.ok("编辑博文成功！");
    }

    /**
     * 发布文章
     * @param article
     * @param tagName
     * @param result
     * @return
     */
    @PostMapping("/post")
    @ResponseBody
    public R post(@Valid TArticle article, String tagName, BindingResult result) {
        if (!result.hasErrors()) {
            article.setAuthorId(12345);
            if(articleService.postArticle(article, tagName)) {
            	return R.ok("发布博文成功！");
            } else {
            	return R.error("发布博文失败！");
            }
        } else {
        	return R.error("发布博文失败："+result.getAllErrors().toString());
        }
    }

    @PostMapping("/upload/cover")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam(value = "file", required = false) MultipartFile file, String type) {
        if (file != null) {
            return uploadService.upload(file, type);
        } else {
            return R.err2Map("上传文件为空！");
        }
    }
    
    @PostMapping("/delete/{id}")
    @ResponseBody
    public R delete(@PathVariable("id") String id) {
    	if(articleService.delete(id)!=0) {
    		return R.ok("删除博文成功！");
    	} else {
        	return R.error("删除博文失败！");
        }
    }
    
    @PostMapping("/edit/appreciable/{id}")
    @ResponseBody
    public R appreciable(@PathVariable("id") String id, Boolean appreciable) {
    	if(articleService.updateAppreciableById(id, appreciable)!=0) {
    		return R.ok("修改点赞状态成功！");
    	} else {
        	return R.error("修改点赞状态失败！");
        }
    }

    @PostMapping("/edit/commented/{id}")
    @ResponseBody
    public R commented(@PathVariable("id") String id, Boolean commented) {
    	if(articleService.updateCommentedById(id, commented)!=0) {
    		return R.ok("修改评论状态成功！");
    	} else {
        	return R.error("修改评论状态失败！");
        }
    }
}
