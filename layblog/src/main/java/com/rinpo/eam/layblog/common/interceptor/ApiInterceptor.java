package com.rinpo.eam.layblog.common.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rinpo.eam.layblog.common.AppContants;
import com.rinpo.eam.layblog.utils.CookieUtils;
import com.rinpo.eam.layblog.utils.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * 处理基于token请求的拦截器
 */
public class ApiInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		Cookie sso_token_cookie = CookieUtils.getCookie(request, AppContants.COOKIE_SSO_TOKEN);
		if(sso_token_cookie!=null) {
			//有cookie，进一步验证
			String sso_token = sso_token_cookie.getValue();
			String userId = null;
			try { 
				// 解析token
				userId = JwtUtil.parseToken(sso_token, null).getSubject();
				request.setAttribute("userId", userId);
			} catch (ExpiredJwtException e) {
				throw new RuntimeException("token过期，请重新登录");
			} catch (Exception e) {
				throw new RuntimeException(e.getLocalizedMessage()+"，请重新登录");
			}
			
		} else {
			//没有cookie，跳转到登录页面重新登录
			logger.info("没有获取到cookie：sso_token，重定向到login");
			response.sendRedirect("/login");
		}
		return true;
	}

}