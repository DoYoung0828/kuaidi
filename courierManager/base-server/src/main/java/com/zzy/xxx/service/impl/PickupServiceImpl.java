package com.zzy.xxx.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.mapper.CarMapper;
import com.zzy.xxx.mapper.LogisticsInfoMapper;
import com.zzy.xxx.pojo.Car;
import com.zzy.xxx.pojo.Express;
import com.zzy.xxx.pojo.LogisticsInfo;
import com.zzy.xxx.pojo.Pickup;
import com.zzy.xxx.mapper.PickupMapper;
import com.zzy.xxx.service.PickupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.PickupParam;
import com.zzy.xxx.vo.PickupVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 取件信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PickupServiceImpl extends ServiceImpl<PickupMapper, Pickup> implements PickupService {

    private final PickupMapper pickupMapper;
    private final LogisticsInfoMapper logisticsInfoMapper;
    private final CarMapper carMapper;

    /**
     * 分页条件查询寄件中心
     *
     * @param param 参数
     * @return 结果
     */
    @Override
    public PageResult<PickupVo> pickupPage(PickupParam param) {
        final Page<PickupVo> queryPage = new Page<>(param.getPageNo(), param.getPageSize());
        final Page<PickupVo> resultPage = pickupMapper.pickupPage(queryPage, param);
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }

    /**
     * 用户寄件下单
     *
     * @param pickup 参数
     */
    @Override
    public void userSender(Pickup pickup) {
        // 生成快递单号
        final String time = DateUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss");
        pickup.setExpressNo(time + RandomUtil.randomInt(100000,999999));
        // 初始化寄件状态
        pickup.setStatus(0);
        pickup.setItemNo(pickup.getItemNo());
        pickupMapper.insert(pickup);
    }

    @Override
    public void adminSender(Pickup pickup) {
        // 修改寄出状态
        pickup.setStatus(4);
        pickupMapper.updateById(pickup);

        // 创建物流信息
        final LogisticsInfo logisticsInfo = new LogisticsInfo();
        logisticsInfo.setPickExpressId(pickup.getId());
        logisticsInfo.setDeliveryTime(LocalDateTime.now());
        logisticsInfo.setCurrentStatus(0);
        logisticsInfo.setCurrentLocation("以装车，准备发往目的地");
        logisticsInfoMapper.insert(logisticsInfo);
    }

    @Override
    public void dronePickup(Long droneId, Long expressId) {
        // 修改订单状态
        final Pickup pickup = new Pickup();
        pickup.setId(expressId);
        pickup.setStatus(1);
        pickupMapper.updateById(pickup);

        // 将无人机设为运作中
        final Car car = new Car();
        car.setId(droneId);
        car.setIsIdle(false);
        carMapper.updateById(car);
    }
}
