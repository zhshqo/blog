package com.rinpo.eam.layblog.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对Cookie的操作类
 */
public class CookieUtils {


    public static Cookie getCookie(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCurrentRequestCookieMap(request);
        Cookie cookie = cookieMap.get(name);
        if(cookie == null) {
        	return null;
        }
        return cookie;
    }

    /**
     * cookie.setMaxAge(0);//不记录cookie
	 * cookie.setMaxAge(-1);//会话级cookie，关闭浏览器失效
     * cookie.setMaxAge(60*60);//过期时间为1小时
     * @param response
     * @param name
     * @param value
     * @param time
     * @return
     */
    public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value, int time) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(time);
        response.addCookie(cookie);
        return response;
    }

    /**
     * cookie.setMaxAge(0);//不记录cookie
	 * cookie.setMaxAge(-1);//会话级cookie，关闭浏览器失效
     * cookie.setMaxAge(60*60);//过期时间为1小时
     * @param response
     * @param name
     * @param domain
     * @param value
     * @param time
     * @return
     */
    public static HttpServletResponse setCookie(HttpServletResponse response, String name, String domain, String value, int time) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setDomain(domain);
        cookie.setMaxAge(time);
        response.addCookie(cookie);
        return response;
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Map<String, Cookie> cookieMap = readCurrentRequestCookieMap(request);
        loopDelCookieMap(response, name, cookieMap);
    }

    private static void loopDelCookieMap(HttpServletResponse response, String name, Map<String, Cookie> cookieMap) {
    	for (String key : cookieMap.keySet()) {
    		if (key.equals(name)) {
                Cookie cookie = cookieMap.get(key);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
		}
    }

    private static Map<String, Cookie> readCurrentRequestCookieMap(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String, Cookie> cookieMap = new HashMap<>();
        if (null != cookies) {
        	for (Cookie cookie : cookies) {
        		cookieMap.put(cookie.getName(), cookie);
			}
        }
        return cookieMap;
    }
}