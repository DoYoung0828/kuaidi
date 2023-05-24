package com.zzy.xxx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.pojo.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.CarParam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 无人机表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface CarMapper extends BaseMapper<Car> {

    Page<Car> carPage(@Param("queryPage") Page<Car> queryPage, @Param("param") CarParam param);
}
