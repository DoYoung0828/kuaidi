package com.zzy.xxx.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/18
 */
@Data
public class StaticsVo {

    /**
     * 用户总数
     */
    private long userTotal;

    /**
     * 快递总数
     */
    private long expressTotal;

    /**
     * 今日收件
     */
    private long pickTotal;

    /**
     * 今日派件
     */
    private long deliveryTotal;
}
