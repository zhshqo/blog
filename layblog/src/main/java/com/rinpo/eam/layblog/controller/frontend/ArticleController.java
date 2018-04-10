package com.rinpo.eam.layblog.controller.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rinpo.eam.layblog.model.TArticle;
import com.rinpo.eam.layblog.model.TComment;
import com.rinpo.eam.layblog.service.admin.ArticleService;
import com.rinpo.eam.layblog.service.admin.CateService;
import com.rinpo.eam.layblog.service.admin.TagService;
import com.rinpo.eam.layblog.service.admin.UserService;
import com.rinpo.eam.layblog.service.frontend.CommentService;
import com.rinpo.eam.layblog.vo.R;
import com.rinpo.eam.layblog.vo.WebParams;
import com.rinpo.eam.layblog.vo.frontend.CommentsVo;

/**
 */
@Controller("frontendArticleController")
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CateService cateService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public String index(Model model, @PathVariable("id") String id) {
        try {
        	//浏览数加1
        	articleService.updateViewsById(id);
        } catch (Exception ignore) {
        }
        TArticle article = articleService.findOne(id);
        model.addAttribute("cateList", cateService.findAll());
        model.addAttribute("article", article);
        model.addAttribute("tags", tagService.findTagsByArticleId(article.getId()));
        model.addAttribute("author", userService.findNicknameById(article.getAuthorId()));
        model.addAttribute("articles", articleService.findSimilarArticles(article.getCateId(), 10));
        model.addAttribute("similars", articleService.findSimilarArticles(article.getCateId(), 6));
        CommentsVo commentsVo = new CommentsVo();
        List<TComment> commentList = commentService.selectByArticle(article.getId());
        commentsVo.setResult(commentList);
        commentsVo.setTotalCount(commentList.size());
        model.addAttribute("comments",commentsVo);
        model.addAttribute("webParams", new WebParams());
        model.addAttribute("su", null);
        return "frontend/article";
    }

    @PostMapping("/approve")
    @ResponseBody
    public R approve(@RequestParam String articleId) {
    	if(articleService.updateApproveCntById(articleId)!=0) {
    		return R.ok("点赞成功！");
    	} else {
    		return R.error("点赞失败！");
    	}
    }
}
