package com.zzy.xxx.controller;


import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.pojo.User;
import com.zzy.xxx.service.UserService;
import com.zzy.xxx.vo.LoginParam;
import com.zzy.xxx.vo.LoginSuccessVo;
import com.zzy.xxx.vo.SiteAdminVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public CommonResult<LoginSuccessVo> login(@RequestBody LoginParam param) {
        log.info("用户登录，参数:{}",param);
        final LoginSuccessVo loginResult = userService.login(param);
        return success(loginResult);
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public CommonResult<Void> register(@RequestBody User user) {
        log.info("用户注册，参数:{}",user);
        userService.register(user);
        return success();
    }

    /**
     * 封禁/解封
     */
    @PutMapping("/enable")
    public CommonResult<Void> changeEnable(@RequestBody User user) {
        log.info("封禁/解封，参数：{}",user);
        userService.updateById(user);
        return success();
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public CommonResult<Void> deleteById(@PathVariable Long id) {
        log.info("删除用户，参数：{}", id);
        userService.removeById(id);
        return success();
    }

    /**
     * 添加驿站管理员
     */
    @PostMapping("/add-admin")
    public CommonResult<Void> addAdmin(@RequestBody SiteAdminVo adminVo) {
        log.info("添加驿站管理员，参数：{}", adminVo);
        userService.addSiteAdmin(adminVo);
        return success();
    }
}
