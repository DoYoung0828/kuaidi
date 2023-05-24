package com.zzy.xxx.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 认证token
 * @author: zzy
 * @date: 2023/1/20
 */
public class AuthToken implements AuthenticationToken {

    private String token;

    public AuthToken() {

    }

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
