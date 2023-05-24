package com.zzy.xxx.vo;

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
@ToString
public class PickStaticsVo {

    /**
     * 日期
     */
    private String date;

    /**
     * 收件数
     */
    private Long pickupCount;

    /**
     * 派件数
     */
    private Long deliveryCount;
}
