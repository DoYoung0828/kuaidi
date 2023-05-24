package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Car;
import com.zzy.xxx.mapper.CarMapper;
import com.zzy.xxx.pojo.UserInfo;
import com.zzy.xxx.service.CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.CarParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 无人机表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@RequiredArgsConstructor
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

    private final CarMapper carMapper;

    /**
     * 分页查询无人机信息
     * @param param 查询参数
     * @return 查询结果
     */
    @Override
    public PageResult<Car> carPage(CarParam param) {
        final Page<Car> queryPage = new Page<>(param.getPageNo(), param.getPageSize());
        final Page<Car> resultPage = carMapper.carPage(queryPage, param);
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }
}
