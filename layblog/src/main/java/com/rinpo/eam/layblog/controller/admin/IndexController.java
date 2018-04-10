package com.rinpo.eam.layblog.controller.admin;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rinpo.eam.layblog.common.AppContants;
import com.rinpo.eam.layblog.model.TUser;
import com.rinpo.eam.layblog.utils.WebSessionUtil;

@Controller("adminIndexController")
@RequestMapping("/admin")
public class IndexController {

    @GetMapping(value = {"", "/index"})
    public String index(Model model) {
    	TUser user = (TUser)WebSessionUtil.getSessionAttribute(AppContants.SESSION_USER_KEY);
    	if(user==null) {
    		return "redirect:/login";
    	}
        model.addAttribute("avatar", user.getAvatar());
        model.addAttribute("nickname", user.getNickname());
        return "admin/admin_index";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("articleCnt", 5);
        model.addAttribute("noteCnt", 6);
        model.addAttribute("commentCnt", 7);
        model.addAttribute("latestArticle", "斯柯达减肥开始京东方扩散到甲方会计师地方");
        model.addAttribute("latestNote", "水电费水电费是否");
        
        Map<String, Object> newMap = new TreeMap<>();
        newMap.put("111", "sdsds");
        model.addAttribute("latestComment", newMap);
        
        return "admin/admin_home";
    }

}
