package com.zzy.xxx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.pojo.User;
import com.zzy.xxx.service.RoleService;
import com.zzy.xxx.service.UserService;
import com.zzy.xxx.vo.PickStaticsVo;
import com.zzy.xxx.vo.StaticsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

    private final UserService userService;

    /**
     * 查询所有无人机管理员信息
     */
    @GetMapping("/courier/list")
    public CommonResult<List<User>> courierList() {
        log.info("查询所有无人机管理员信息");
        final List<User> userList = userService.list(new QueryWrapper<User>().eq("role_id", 2));
        return success(userList);
    }

    /**
     * 查询首页第一行统计
     */
    @GetMapping("/statics")
    public CommonResult<StaticsVo> getStatics() {
        log.info("查询首页第一行统计");
        final StaticsVo staticsVo = userService.getStatics();
        return success(staticsVo);
    }

    /**
     * 查询近6天的收件派件数
     */
    @GetMapping("/pickAndDeliver")
    public CommonResult<List<PickStaticsVo>> getPickStatics() {
        log.info("查询近6天的收件派件数");
        final List<PickStaticsVo> pickStaticsVos = userService.getPickStatics();
        return success(pickStaticsVos);
    }
}
