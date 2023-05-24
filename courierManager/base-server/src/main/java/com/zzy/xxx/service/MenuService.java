package com.zzy.xxx.service;

import com.zzy.xxx.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface MenuService extends IService<Menu> {

    /**
     * 根据角色id查询菜单列表
     *
     * @param roleId 角色id
     * @param userId 用户id
     * @return 菜单列表
     */
    List<Menu> selectByRoleId(Long roleId, Long userId);

    /**
     * 查询管理员可配置菜单
     * @param roleIdFromToken 角色id
     * @return
     */
    List<Menu> getAdminList(Long roleIdFromToken);

    /**
     * 查询管理员拥有菜单
     * @param userId
     * @return
     */
    List<Long> getAdminMenuIds(Long userId);
}
