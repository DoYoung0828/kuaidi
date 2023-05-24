package com.zzy.xxx.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzy.xxx.pojo.LogisticsInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/17
 */
@Data
public class PickupVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "快递单号")
    private String expressNo;

    @ApiModelProperty(value = "下单用户")
    private String username;

    @ApiModelProperty(value = "寄件人姓名")
    private String pickupName;

    @ApiModelProperty(value = "寄件人电话")
    private String pickupPhone;

    @ApiModelProperty(value = "寄件地址")
    private String pickupAddress;

    @ApiModelProperty(value = "收件人姓名")
    private String receiverName;

    @ApiModelProperty(value = "收件人电话")
    private String receiverPhone;

    @ApiModelProperty(value = "收件人地址")
    private String receiverAddress;

    @ApiModelProperty(value = "快递公司")
    private String expressCompany;

    private BigDecimal amount;

    @ApiModelProperty(value = "下单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;

    @ApiModelProperty(value = "订单状态：0：待无人机取件；1：已取件，待送达；2：已送达，待审核；3：已审核，待寄出；4：已寄出；5：审核未通过")
    private Integer status;

    @ApiModelProperty(value = "物流状态")
    private LogisticsInfo logistics;

    @ApiModelProperty(value = "柜号")
    private String itemNo;

}
