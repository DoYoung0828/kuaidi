package com.zzy.xxx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.pojo.Pickup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.PickupParam;
import com.zzy.xxx.vo.PickupVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 取件信息表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface PickupMapper extends BaseMapper<Pickup> {

    Page<PickupVo> pickupPage(@Param("queryPage") Page<PickupVo> queryPage, @Param("param") PickupParam param);
}
