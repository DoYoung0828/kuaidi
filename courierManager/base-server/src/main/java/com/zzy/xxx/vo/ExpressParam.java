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
public class ExpressParam extends PageParam {

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 取件码
     */
    private String expressCode;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 驿站点
     */
    private Long siteId;
}
