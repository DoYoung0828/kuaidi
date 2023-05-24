package com.zzy.xxx.controller;


import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.service.AdminMenuService;
import com.zzy.xxx.vo.AdminMenuVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin-menu")
public class AdminMenuController {

    private final AdminMenuService adminMenuService;

    /**
     * 更新管理员菜单权限
     */
    @PutMapping("/update")
    public CommonResult<Void> updateMenu(@RequestBody AdminMenuVo param) {
        log.info("更新管理员菜单权限,参数：{}", param);
        adminMenuService.updateMenu(param);
        return success();
    }
}
