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
 * @date: 2023/4/17
 */
@Setter
@Getter
@ToString(callSuper = true)
public class DeliveryParam extends PageParam {

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 快递状态
     */
    private Integer expressStatus;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户手机号
     */
    private String phone;
}
