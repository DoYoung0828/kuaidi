package com.zzy.xxx.service;

import com.zzy.xxx.pojo.AdminMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.AdminMenuVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface AdminMenuService extends IService<AdminMenu> {

    /**
     * 更新管理员权限菜单
     *
     * @param param 参数
     */
    void updateMenu(AdminMenuVo param);
}
