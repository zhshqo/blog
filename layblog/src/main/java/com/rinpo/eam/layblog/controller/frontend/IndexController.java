package com.rinpo.eam.layblog.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rinpo.eam.layblog.service.frontend.IndexService;
import com.rinpo.eam.layblog.vo.Page;
import com.rinpo.eam.layblog.vo.R;
import com.rinpo.eam.layblog.vo.admin.ArticleVo;
import com.rinpo.eam.layblog.vo.frontend.IndexArticleQueryVo;
import com.rinpo.eam.layblog.vo.frontend.IndexArticleVo;


/**
 */
@Controller("frontendIndexController")
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping(value = {"", "/index"})
    public String index(Model model) {
        model.addAttribute("indexVo", indexService.findIndexVo());
        return "frontend/index";
    }

    @PostMapping(value = {"/next", "/index/next"})
    @ResponseBody
    public R next(IndexArticleQueryVo indexArticleBo) {
        IndexArticleVo indexArticleVo = indexService.next(indexArticleBo);
        return R.ok(indexArticleVo);
    }
}
