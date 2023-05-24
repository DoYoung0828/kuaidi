package com.zzy.xxx.service;

import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Express;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.ExpressParam;

/**
 * <p>
 * 快递表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface ExpressService extends IService<Express> {

    /**
     * 分页条件查询快递订单
     *
     * @param param 查询参数
     * @return 查询结果
     */
    PageResult<Express> pageExpress(ExpressParam param);

    /**
     * 快递员接单
     * @param droneId 无人机ID
     * @param id 快递id
     * @param userId 用户id
     */
    void courierPick(Long droneId, Long id, Long userId);
}
