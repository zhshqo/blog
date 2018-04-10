package com.rinpo.eam.layblog.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rinpo.eam.layblog.common.interceptor.ApiInterceptor;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {

        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new ApiInterceptor())
        	.addPathPatterns("/**")
        	.excludePathPatterns("/login");
        super.addInterceptors(registry);
    }
}