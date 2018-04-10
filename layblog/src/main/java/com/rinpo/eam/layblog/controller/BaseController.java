package com.rinpo.eam.layblog.controller;

import static org.springframework.util.StringUtils.isEmpty;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rinpo.eam.layblog.vo.Page;
import com.rinpo.eam.layblog.vo.layui.table.LayuiTable;

public abstract class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    //TODO:替换注释内容
    protected static String basePath(HttpServletRequest request) {
        String bathPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        logger.info("当前域名：[{}]", bathPath);
        return bathPath;
//        return "http://wuwenbin.me/";
    }

    protected static <T> LayuiTable<T> layuiTable(Page<T> page) {
        return new LayuiTable<>(page.getTotalCount(), page.getTResult());
    }

    protected boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equalsIgnoreCase(header);
    }

    protected boolean isJson(HttpServletRequest request) {
        String headerAccept = request.getHeader("Accept");
        return !isEmpty(headerAccept) && headerAccept.contains("application/json");
    }

    protected boolean isRouter(HttpServletRequest request) {
        String headerAccept = request.getHeader("Accept");
        return !isEmpty(headerAccept) && headerAccept.contains("text/html") && !isJson(request) && isAjax(request) && isGet(request);
    }

    protected boolean isGet(HttpServletRequest request) {
        String method = request.getMethod();
        return "GET".equalsIgnoreCase(method);
    }

}
