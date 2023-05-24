package com.zzy.xxx.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 派件信息表
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_delivery")
@ApiModel(value="Delivery对象", description="派件信息表")
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "快递单号")
    private String expressNo;

    @ApiModelProperty(value = "派件员ID")
    private Long courierId;

    @ApiModelProperty(value = "派件无人机ID")
    private Long droneId;

    @ApiModelProperty(value = "快递状态：0表示未送达，1表示已送达")
    private Integer expressStatus;

    @ApiModelProperty(value = "送达时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    /**
     * 无人机管理员姓名
     */
    @TableField(exist = false)
    private String name;

    /**
     * 无人机管理员电话
     */
    @TableField(exist = false)
    private String phone;

    /**
     * 无人机信息
     */
    @TableField(exist = false)
    private Car car;
}
