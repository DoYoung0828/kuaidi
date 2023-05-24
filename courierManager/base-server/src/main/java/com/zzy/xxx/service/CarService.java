package com.zzy.xxx.service;

import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.CarParam;

/**
 * <p>
 * 无人机表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface CarService extends IService<Car> {

    /**
     * 分页查询无人机信息
     * @param param 查询参数
     * @return 查询结果
     */
    PageResult<Car> carPage(CarParam param);
}
