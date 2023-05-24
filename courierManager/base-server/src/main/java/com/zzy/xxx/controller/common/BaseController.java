package com.zzy.xxx.controller.common;

import com.zzy.xxx.shiro.AuthJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/17
 */
public abstract class BaseController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 从请求头中获取token，解析用户id
     *
     * @return 当前操作用户id
     */
    public final Long getUserIdFromToken() {
        String token = request.getHeader("Authorization");
        Assert.notNull(token,"请求头中未携带token");
        Map<String, Object> claims = AuthJwt.getClaim(token.substring(7)).asMap();
        final String stringUserId = claims.get("userId").toString();
        return Long.parseLong(stringUserId);
    }

    /**
     * 从请求头中获取token，解析用户角色id
     *
     * @return 当前操作用户角色id
     */
    public final Long getRoleIdFromToken() {
        String token = request.getHeader("Authorization");
        Assert.notNull(token,"请求头中未携带token");
        Map<String, Object> claims = AuthJwt.getClaim(token.substring(7)).asMap();
        final String stringRoleId = claims.get("roleId").toString();
        return Long.parseLong(stringRoleId);
    }

    /**
     * 从请求头中获取token，解析管理员所属站点id
     *
     * @return 当前管理员站点ID
     */
    public final Long getSiteIdFromToken() {
        String token = request.getHeader("Authorization");
        Assert.notNull(token,"请求头中未携带token");
        Map<String, Object> claims = AuthJwt.getClaim(token.substring(7)).asMap();
        final String stringSiteId = claims.get("siteId").toString();
        if (Objects.isNull(stringSiteId)) {
            return null;
        }
        return Long.parseLong(stringSiteId);
    }
}
