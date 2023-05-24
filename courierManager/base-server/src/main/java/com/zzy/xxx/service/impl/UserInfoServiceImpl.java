package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.UserInfo;
import com.zzy.xxx.mapper.UserInfoMapper;
import com.zzy.xxx.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.UserParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    private final UserInfoMapper userInfoMapper;

    @Override
    public PageResult<UserInfo> selectConditionPage(UserParam param) {
        final Page<UserInfo> queryPage = new Page<>(param.getPageNo(), param.getPageSize());
        final Page<UserInfo> resultPage = userInfoMapper.selectConditionPage(queryPage, param);
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }
}
