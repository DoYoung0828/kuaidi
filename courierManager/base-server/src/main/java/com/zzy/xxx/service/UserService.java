package com.zzy.xxx.service;

import com.zzy.xxx.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.*;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录，返回token
     *
     * @param param 登录参数
     * @return 结果
     */
    LoginSuccessVo login(LoginParam param);

    /**
     * 用户注册，生成默认用户信息
     *
     * @param user 注册参数
     */
    void register(User user);

    /**
     * 查询首页第一行统计
     *
     * @return 统计结果
     */
    StaticsVo getStatics();

    /**
     * 查询近6天的收件派件数
     */
    List<PickStaticsVo> getPickStatics();

    /**
     * 添加驿站管理员
     * @param adminVo 参数
     */
    void addSiteAdmin(SiteAdminVo adminVo);
}
