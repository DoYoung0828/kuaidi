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
@ToString
public class CarParam extends PageParam {

    /**
     * 车牌
     */
    private String carNo;

    /**
     * 型号
     */
    private String carType;

    /**
     * 用户Id
     */
    private Long userId;
}
