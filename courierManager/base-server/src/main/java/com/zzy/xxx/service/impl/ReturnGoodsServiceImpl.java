package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.mapper.DeliveryMapper;
import com.zzy.xxx.mapper.UserInfoMapper;
import com.zzy.xxx.pojo.Delivery;
import com.zzy.xxx.pojo.ReturnGoods;
import com.zzy.xxx.mapper.ReturnGoodsMapper;
import com.zzy.xxx.pojo.UserInfo;
import com.zzy.xxx.service.ReturnGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.DeliveryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@RequiredArgsConstructor
@Service
public class ReturnGoodsServiceImpl extends ServiceImpl<ReturnGoodsMapper, ReturnGoods> implements ReturnGoodsService {

    private final ReturnGoodsMapper returnGoodsMapper;
    private final UserInfoMapper userInfoMapper;
    private final DeliveryMapper deliveryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void returnGoods(Delivery delivery) {
        delivery.setExpressStatus(2);
        deliveryMapper.updateById(delivery);

        final ReturnGoods returnGoods = new ReturnGoods();
        returnGoods.setExpressNo(delivery.getExpressNo());
        returnGoods.setCourierId(delivery.getCourierId());
        returnGoodsMapper.insert(returnGoods);
    }

    @Override
    public PageResult<ReturnGoods> pageReturn(DeliveryParam param) {
        final Page<ReturnGoods> queryPage = new Page<>(param.getPageNo(), param.getPageSize());
        // 如果是普通用户，根据手机号查询当前用户的退款信息
        if (param.getRoleId() == 3) {
            final UserInfo userInfo = userInfoMapper.selectById(param.getUserId());
            param.setPhone(userInfo.getPhone());
        }
        final Page<ReturnGoods> resultPage = returnGoodsMapper.pageReturn(queryPage,param);
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }
}
