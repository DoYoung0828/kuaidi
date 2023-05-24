package com.zzy.xxx.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/17
 */
@Data
public class LoginSuccessVo {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * token
     */
    private String token;
}
