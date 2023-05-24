package com.zzy.xxx.vo;

import com.zzy.xxx.common.PageParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/18
 */
@Setter
@Getter
@ToString(callSuper = true)
public class UserParam extends PageParam {

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色id
     */
    private Long roleId;
}
