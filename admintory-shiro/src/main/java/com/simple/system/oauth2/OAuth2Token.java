package com.simple.system.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

import javax.servlet.ServletRequest;

/**
 * token
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    private ServletRequest request;

    public OAuth2Token(String token, ServletRequest request){
        this.token = token;
        this.request = request;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    public ServletRequest getRequest(){
        return request;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
