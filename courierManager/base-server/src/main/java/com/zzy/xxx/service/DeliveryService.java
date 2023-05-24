package com.zzy.xxx.service;

import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Delivery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.DeliveryParam;

/**
 * <p>
 * 派件信息表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface DeliveryService extends IService<Delivery> {

    /**
     * 分页查询派件信息
     *
     * @param param 查询参数
     * @return 查询结果
     */
    PageResult<Delivery> pageDeliver(DeliveryParam param);
}
