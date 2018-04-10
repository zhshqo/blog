package com.rinpo.eam.layblog.common.exception;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.rinpo.eam.layblog.utils.FastJsonUtil;
import com.rinpo.eam.layblog.vo.R;

/**
 * 异常处理类
 */
@Component
@Order(-1000)
public class ExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);
    
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
    	
    	// 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
        if (responseBody == null) {
            // 如果注解为null, 说明是html页面请求，而不是ajax请求，所以返回500页面
            logger.info("方法："+method.getDeclaringClass()+"."+method.getName()+"请求类型：HTML");
            ModelAndView mv=new ModelAndView();
            mv.setViewName("/error/500");
            mv.addObject("message", ex.getLocalizedMessage());
            return mv;
        } else {
        	logger.info("方法："+method.getDeclaringClass()+"."+method.getName()+"请求类型：JSON");
        	response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache, must-revalidate");  
            try {
                response.getWriter().write(FastJsonUtil.obj2JsonStr(R.error(ex.getLocalizedMessage()), true));
            } catch (IOException e) {
                logger.error("与客户端通讯异常：" + e.getMessage(), e);
            }
            
            logger.debug("异常：" + ex.getMessage(), ex);
            
            return new ModelAndView();
        }
        
    }
    
}
