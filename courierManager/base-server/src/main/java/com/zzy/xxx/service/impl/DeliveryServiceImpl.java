package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.mapper.UserInfoMapper;
import com.zzy.xxx.pojo.Delivery;
import com.zzy.xxx.mapper.DeliveryMapper;
import com.zzy.xxx.pojo.UserInfo;
import com.zzy.xxx.service.DeliveryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.DeliveryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 派件信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {

    private final DeliveryMapper deliveryMapper;
    private final UserInfoMapper userInfoMapper;

    /**
     * 分页查询派件信息
     *
     * @param param 查询参数
     * @return 查询结果
     */
    @Override
    public PageResult<Delivery> pageDeliver(DeliveryParam param) {
        final Page<Delivery> queryPage = new Page<>(param.getPageNo(), param.getPageSize());
        // 如果是普通用户，根据手机号查询当前用户的派件
        if (param.getRoleId() == 3) {
            final UserInfo userInfo = userInfoMapper.selectById(param.getUserId());
            param.setPhone(userInfo.getPhone());
        }
        final Page<Delivery> resultPage = deliveryMapper.pageDeliver(queryPage,param);
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }
}
