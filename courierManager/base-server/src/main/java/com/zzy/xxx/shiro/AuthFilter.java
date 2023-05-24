package com.zzy.xxx.shiro;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.GlobalErrorCodeConstants;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 自定义过滤器
 * @author: zzy
 * @date: 2023/1/20
 */
@Slf4j
public class AuthFilter extends AuthenticatingFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //放行options请求
        return ((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name());
    }

    /**
     * 描述：认证token
     *
     * @author zzy
     * @date 2023/1/20
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = ((HttpServletRequest) servletRequest).getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            log.info("请求头中不存在token，URL：{}",((HttpServletRequest) servletRequest).getRequestURI());
            authTokenFail((HttpServletRequest)servletRequest, (HttpServletResponse) servletResponse);
            return false;
        }
        return executeLogin(servletRequest, servletResponse);
    }

    /**
     * 描述：重写处理认证失败方法
     *
     * @author zzy
     * @date 2023/1/20
     */
    @SneakyThrows
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        authTokenFail((HttpServletRequest) request,(HttpServletResponse) response);
        return super.onLoginFailure(token, e, request, response);
    }

    /**
     * 描述：获取请求头中的token
     *
     * @author zzy
     * @date 2023/1/20
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = ((HttpServletRequest) servletRequest).getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            return null;
        }
        // 去除Bearer 前缀
        return new AuthToken(token.split(" ")[1]);
    }

    /**
     * 描述：token非法，返回错误信息给请求方
     *
     * @author zzy
     * @date 2023/1/20
     */
    private void authTokenFail(HttpServletRequest request,HttpServletResponse servletResponse) throws IOException {
        log.error("认证失败，接口URL：{}",request.getServletPath());
        servletResponse.setContentType("application/json;charset=utf-8");
        servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        servletResponse.setHeader("Access-Control-Allow-Origin", "Origin");
        String json = JSONObject.toJSONString(CommonResult.error(GlobalErrorCodeConstants.UNAUTHORIZED));
        servletResponse.getWriter().print(json);
    }
}
