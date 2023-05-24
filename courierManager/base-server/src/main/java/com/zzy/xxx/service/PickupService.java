package com.zzy.xxx.service;

import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Pickup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.PickupParam;
import com.zzy.xxx.vo.PickupVo;

/**
 * <p>
 * 取件信息表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface PickupService extends IService<Pickup> {

    /**
     * 分页条件查询寄件中心
     *
     * @param param 参数
     * @return 结果
     */
    PageResult<PickupVo> pickupPage(PickupParam param);

    /**
     * 用户寄件下单
     *
     * @param pickup 参数
     */
    void userSender(Pickup pickup);

    /**
     * 管理员寄出快递
     *
     * @param pickup 参数
     */
    void adminSender(Pickup pickup);

    /**
     * 无人机取件
     *
     * @param droneId   无人机id
     * @param expressId 订单id
     */
    void dronePickup(Long droneId, Long expressId);
}
