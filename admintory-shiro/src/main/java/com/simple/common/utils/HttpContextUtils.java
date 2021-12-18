package com.simple.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class HttpContextUtils {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }


    public static String getDomain(){
        HttpServletRequest request = getHttpServletRequest();
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    public static String getOrigin(){
        HttpServletRequest request = getHttpServletRequest();
        return request.getHeader("Origin");
    }

    /**
     * 获取请求的token
     */
    public static String getRequestParam(HttpServletRequest httpRequest, String param){
        //从header中获取token
        String token = httpRequest.getHeader(param);

        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = httpRequest.getParameter(param);
        }

        return token;
    }
    /**
     * 获取请求的token
     */
    public static String getRequestParam(String param){
        //从header中获取token
        String token = getHttpServletRequest().getHeader(param);

        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = getHttpServletRequest().getParameter(param);
        }

        return token;
    }

}