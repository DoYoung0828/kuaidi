package com.zzy.xxx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 取件信息表
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_pickup")
@ApiModel(value="Pickup对象", description="取件信息表")
public class Pickup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "快递单号")
    private String expressNo;

    @ApiModelProperty(value = "下单用户ID")
    private Long userId;

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

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "下单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;

    @ApiModelProperty(value = "订单状态：0：待无人机取件；1：已取件，待送达；2：已送达，待审核；3：已审核，待寄出；4：已寄出；5：审核未通过")
    private Integer status;

    @ApiModelProperty(value = "物流状态ID")
    private Long logisticsId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    @ApiModelProperty(value = "柜号")
    private String itemNo;

}
