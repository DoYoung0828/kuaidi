package com.zzy.xxx.service;

import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.UserParam;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 分页条件查询用户信息
     *
     * @param param 查询参数
     * @return 查询结果
     */
    PageResult<UserInfo> selectConditionPage(UserParam param);
}
