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
public class PickupParam extends PageParam {

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 下单用户id
     */
    private Long userId;
}
