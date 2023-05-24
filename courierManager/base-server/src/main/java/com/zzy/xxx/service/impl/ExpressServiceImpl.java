package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.mapper.CarMapper;
import com.zzy.xxx.mapper.DeliveryMapper;
import com.zzy.xxx.mapper.UserInfoMapper;
import com.zzy.xxx.pojo.Car;
import com.zzy.xxx.pojo.Delivery;
import com.zzy.xxx.pojo.Express;
import com.zzy.xxx.mapper.ExpressMapper;
import com.zzy.xxx.service.ExpressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.ExpressParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 快递表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ExpressServiceImpl extends ServiceImpl<ExpressMapper, Express> implements ExpressService {

    private final ExpressMapper expressMapper;
    private final DeliveryMapper deliveryMapper;
    private final UserInfoMapper userInfoMapper;
    private final CarMapper carMapper;

    /**
     * 分页条件查询快递订单
     *
     * @param param 查询参数
     * @return 查询结果
     */
    @Override
    public PageResult<Express> pageExpress(ExpressParam param) {
        final Page<Express> queryPage = new Page<>(param.getPageNo(), param.getPageSize());
        // 如果普通用户，查询电话号码，筛选结果
        if (param.getRoleId() == 3) {
            param.setPhone(userInfoMapper.selectById(param.getUserId()).getPhone());
        }
        final Page<Express> resultPage = expressMapper.pageExpress(queryPage,param);
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }

    @Override
    public void courierPick(Long droneId, Long id, Long userId) {

        // 设为已出库
        final Express express = new Express();
        express.setId(id);
        express.setOutTime(LocalDateTime.now());
        express.setStatus(true);
        expressMapper.updateById(express);

        // 添加到派件中心
        final Express exp = expressMapper.selectById(id);
        final Delivery delivery = new Delivery();
        delivery.setExpressNo(exp.getExpressNo());
        delivery.setCourierId(userId);
        delivery.setDroneId(droneId);
        deliveryMapper.insert(delivery);

        // 将无人机设为运作中
        final Car car = new Car();
        car.setId(droneId);
        car.setIsIdle(false);
        carMapper.updateById(car);
    }
}
