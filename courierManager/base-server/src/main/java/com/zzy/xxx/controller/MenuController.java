package com.zzy.xxx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.controller.common.BaseController;
import com.zzy.xxx.pojo.Menu;
import com.zzy.xxx.service.AdminMenuService;
import com.zzy.xxx.service.MenuService;
import com.zzy.xxx.vo.MenuVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    private final MenuService menuService;

    /**
     * 查询用户菜单列表
     */
    @GetMapping("/list")
    public CommonResult<List<Menu>> getList() {
        final Long userId = getUserIdFromToken();
        final Long roleId = getRoleIdFromToken();
        log.info("查询用户菜单列表，参数：{},{}", roleId, userId);
        List<Menu> menuList = menuService.selectByRoleId(roleId, userId);
        return success(menuList);
    }

    /**
     * 查询管理员可配置菜单
     */
    @GetMapping("/admin/list")
    public CommonResult<List<MenuVo>> getAdminList() {
        log.info("查询管理员可配置菜单列表");
        List<Menu> menuList = menuService.getAdminList(1L);
        final List<MenuVo> menuVoList = menuList.stream()
                .map(menu -> MenuVo.builder().id(menu.getId()).name(menu.getTitle()).build())
                .collect(Collectors.toList());
        menuVoList.forEach(menuVo -> {
            if (1 == menuVo.getId() || 2 == menuVo.getId()) {
                menuVo.setDisabled(true);
            }
        });
        log.info("查询管理员可配置菜单列表，结果：{}",menuVoList);
        return success(menuVoList);
    }

    /**
     * 查询当前管理员拥有菜单
     */
    @GetMapping("/admin/{id}")
    public CommonResult<List<Long>> getAdminMenu(@PathVariable Long id) {
        log.info("查询当前管理员拥有菜单，参数：{}",id);
        final List<Long> adminMenuIds = menuService.getAdminMenuIds(id);
        return success(adminMenuIds);
    }

}
