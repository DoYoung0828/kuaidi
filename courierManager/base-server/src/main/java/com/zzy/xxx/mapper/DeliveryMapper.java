package com.zzy.xxx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.pojo.Delivery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.DeliveryParam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 派件信息表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface DeliveryMapper extends BaseMapper<Delivery> {

    Page<Delivery> pageDeliver(@Param("queryPage") Page<Delivery> queryPage, @Param("param") DeliveryParam param);
}
