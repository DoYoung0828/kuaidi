package com.zzy.xxx.service;

import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Delivery;
import com.zzy.xxx.pojo.ReturnGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.DeliveryParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface ReturnGoodsService extends IService<ReturnGoods> {

    /**
     * 申请退货
     *
     * @param delivery
     */
    void returnGoods(Delivery delivery);

    /**
     * 分页查询
     * @param param
     * @return
     */
    PageResult<ReturnGoods> pageReturn(DeliveryParam param);
}
