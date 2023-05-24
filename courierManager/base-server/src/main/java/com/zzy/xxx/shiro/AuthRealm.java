package com.zzy.xxx.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/1/20
 */
@Component
public class AuthRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    /**
     * 描述：授权
     *
     * @author zzy
     * @date 2023/1/20
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 描述：认证
     *
     * @author zzy
     * @date 2023/1/20
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 校验token进行认证
        return AuthJwt.verifyToken(authenticationToken.getPrincipal().toString())
                ? new SimpleAuthenticationInfo(authenticationToken.getPrincipal(), authenticationToken.getCredentials(), this.getName()) : null;
    }
}
