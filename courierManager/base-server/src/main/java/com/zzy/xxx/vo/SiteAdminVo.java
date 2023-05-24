package com.zzy.xxx.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/5/5
 */
@Data
public class SiteAdminVo {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 所属驿站
     */
    private Long siteId;

}
