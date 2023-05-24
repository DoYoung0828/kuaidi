package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.xxx.mapper.AdminMenuMapper;
import com.zzy.xxx.pojo.AdminMenu;
import com.zzy.xxx.pojo.Menu;
import com.zzy.xxx.mapper.MenuMapper;
import com.zzy.xxx.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    private final MenuMapper menuMapper;
    private final AdminMenuMapper adminMenuMapper;

    /**
     * 根据角色id查询菜单列表
     *
     * @param roleId 角色id
     * @param userId 用户id
     * @return 菜单列表
     */
    @Override
    public List<Menu> selectByRoleId(Long roleId, Long userId) {
        List<Menu> menuList = menuMapper.selectByRoleId(roleId);

        // 如果是管理员，进行筛选
        if (1 == roleId) {
            final List<Long> adminMenuIds = getAdminMenuIds(userId);
            menuList = menuList.stream().filter(m -> adminMenuIds.contains(m.getId())).collect(Collectors.toList());
        }
        return menuList;
    }

    @Override
    public List<Long> getAdminMenuIds(Long userId) {
        return adminMenuMapper.selectObjs(
                new QueryWrapper<AdminMenu>().select("menu_id").eq("user_id", userId)
        ).stream().map(obj -> Long.parseLong(String.valueOf(obj))).collect(Collectors.toList());
    }

    @Override
    public List<Menu> getAdminList(Long roleIdFromToken) {
        return menuMapper.selectByRoleId(roleIdFromToken);
    }
}
