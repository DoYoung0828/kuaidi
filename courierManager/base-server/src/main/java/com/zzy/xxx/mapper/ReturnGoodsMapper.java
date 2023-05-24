package com.zzy.xxx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.pojo.ReturnGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.DeliveryParam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface ReturnGoodsMapper extends BaseMapper<ReturnGoods> {

    Page<ReturnGoods> pageReturn(@Param("queryPage") Page<ReturnGoods> queryPage, @Param("param") DeliveryParam param);
}
