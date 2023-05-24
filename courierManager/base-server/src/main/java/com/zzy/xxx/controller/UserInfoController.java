package com.zzy.xxx.controller;


import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.controller.common.BaseController;
import com.zzy.xxx.mapper.UserInfoMapper;
import com.zzy.xxx.pojo.*;
import com.zzy.xxx.service.UserInfoService;
import com.zzy.xxx.service.UserService;
import com.zzy.xxx.utils.HashUtil;
import com.zzy.xxx.vo.UserParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user-info")
public class UserInfoController extends BaseController {

    private final UserInfoService userInfoService;

    @Autowired
    UserService userService;

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 查询用户信息
     */
    @GetMapping("/")
    public CommonResult<UserInfo> getUserInfo() {
        final Long userId = getUserIdFromToken();
        log.info("查询用户信息，参数：{}", userId);
        UserInfo userInfo = userInfoService.getOne(new QueryWrapper<UserInfo>()
                .eq("user_id", userId));
        return success(userInfo);
    }

    //获取用户列表
    @GetMapping("/getUserList")
    public CommonResult<PageResult<UserInfo>> getUserList(String name, Integer pageNo, Integer pageSize) {

        final Page<UserInfo> queryPage = new Page<>(pageNo, pageSize);
        Page<UserInfo> userList = userInfoMapper.getUserList(queryPage, name);
        PageResult<UserInfo> userInfoPageResult1 = new PageResult<>(userList.getRecords(), userList.getTotal());
        return success(userInfoPageResult1);
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/")
    public CommonResult<Void> updateInfo(@RequestBody UserInfo userInfo) {
        log.info("修改用户信息，参数：{}",userInfo);
        userInfoService.updateById(userInfo);

        User user = new User();
        user.setId(userInfo.getUserId());
        user.setPassword(HashUtil.createMd5Hash(userInfo.getPassword()));
        userService.updateById(user);

        return success();
    }

    /**
     * 分页查询无人机管理员信息
     */
    @PostMapping("/courier/page")
    public CommonResult<PageResult<UserInfo>> courierPage(@RequestBody UserParam param) {
        log.info("分页查询无人机管理员信息，参数:{}",param);
        param.setRoleId(2L);

        final PageResult<UserInfo> userInfoPageResult = userInfoService.selectConditionPage(param);
        return success(userInfoPageResult);
    }

    /**
     * 分页查询管理员信息
     */
    @PostMapping("/admin/page")
    public CommonResult<PageResult<UserInfo>> adminPage(@RequestBody UserParam param) {
        log.info("分页查询驿站管理员信息，参数:{}",param);
        param.setRoleId(1L);

        final PageResult<UserInfo> userInfoPageResult = userInfoService.selectConditionPage(param);
        return success(userInfoPageResult);
    }
}
