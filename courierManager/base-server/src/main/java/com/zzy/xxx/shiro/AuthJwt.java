package com.zzy.xxx.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: Jwt相关方法
 * @author: zzy
 * @date: 2023/1/20
 */
@Slf4j
public class AuthJwt {

    private static final String SECRET = "@#9ymw_z1xt";

    /**
     * 描述：生成token
     *
     * @param claims 载荷
     * @return token
     * @author zzy
     * @date 2022/12/30
     */
    public static String createToken(Map<String, Object> claims) {
        //设置过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        //生成token
        String token = JWT.create()
                //加入载荷
                .withClaim("claims", claims)
                //过期时间
                .withExpiresAt(calendar.getTime())
                //加密签名
                .sign(Algorithm.HMAC256(SECRET));
        log.info("create token success token->{}", token);
        return token;
    }

    /**
     * @param token: 需要校验的token
     * @return true为成功，反正失败
     * @desc 校验token
     * @author zzy
     * @date 2022/12/30
     */
    public static boolean verifyToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        } catch (Exception e) {
            log.error("token verify Fail,{}", e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * @param token: 解析的token
     * @return claim
     * @desc 得到载荷
     * @author zzy
     * @date 2022/12/30
     */
    public static Claim getClaim(String token) {
        if (StringUtils.isBlank(token)) {
            log.warn("The token is blank token -> {}", token);
            return null;
        }
        return JWT.decode(token).getClaim("claims");
    }
}
