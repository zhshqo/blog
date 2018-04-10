package com.rinpo.eam.layblog.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rinpo.eam.layblog.common.AppContants;
import com.rinpo.eam.layblog.model.TUser;
import com.rinpo.eam.layblog.service.admin.UserService;
import com.rinpo.eam.layblog.utils.CookieUtils;
import com.rinpo.eam.layblog.utils.DateUtil;
import com.rinpo.eam.layblog.utils.JwtUtil;
import com.rinpo.eam.layblog.utils.WebSessionUtil;
import com.rinpo.eam.layblog.utils.security.Encrypt;
import com.rinpo.eam.layblog.vo.R;

/**
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页面
     * @param uuid
     * @return
     */
    @GetMapping("/login")
    public String login(@CookieValue(value = AppContants.COOKIE_SSO_TOKEN, required = false) String uuid) {
    	//如果cookie中有id，直接转到主页
        if (StringUtils.isEmpty(uuid)) {
            return "admin/admin_login";
        } else {
        	//验证uuid的有效性
        	String userId=null;
			try {
				userId = JwtUtil.parseToken(uuid,null).getSubject();
			} catch (Exception e) {
				return "admin/admin_login";
			}
        	if(userId==null) {
        		return "admin/admin_login";
        	} else {
        		return "admin/admin_index";
        	}
        }
    }

    /**
     * 登录
     * @param request
     * @param response
     * @param bmyName
     * @param bmyPass
     * @param remember
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public R login(HttpServletRequest request, HttpServletResponse response, String bmyName, String bmyPass, Boolean remember) {
        String md52Pass = Encrypt.digest.md5Hex(bmyPass);
        TUser findUser = userService.findByUsernameAndPasswordAndEnable(bmyName, md52Pass, 1);
        if (findUser != null) {
        	//用户存在，则登录成功
        	String ssoToken = JwtUtil.createToken(findUser.getUsername(), null, DateUtil.getAppointDate(new Date(), 30));
        	//设置Session
        	WebSessionUtil.setSessionAttribute(AppContants.SESSION_USER_KEY, findUser);
        	//设置cookie
            if (remember != null && remember.equals(Boolean.TRUE)) {
            	//保存15天
                CookieUtils.setCookie(response, AppContants.COOKIE_SSO_TOKEN, ssoToken, 15 * 24 * 60 * 60);
            } else {
            	//关闭浏览器失效
            	CookieUtils.setCookie(response, AppContants.COOKIE_SSO_TOKEN, ssoToken, -1);
            }
            return R.ok("登陆成功！", "/admin/admin_index");
        } else {
            return R.error("用户名或密码错误！");
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, String from) {
    	//删除session
    	WebSessionUtil.invalidateSession();
        //删除cookie
        CookieUtils.deleteCookie(request, response, AppContants.COOKIE_SSO_TOKEN);
        if (StringUtils.isEmpty(from)) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
}
