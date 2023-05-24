package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.xxx.pojo.AdminMenu;
import com.zzy.xxx.mapper.AdminMenuMapper;
import com.zzy.xxx.service.AdminMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.AdminMenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@RequiredArgsConstructor
@Service
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements AdminMenuService {

    private final AdminMenuMapper adminMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(AdminMenuVo param) {
        adminMenuMapper.delete(new QueryWrapper<AdminMenu>()
                .eq("user_id", param.getId()));

        final List<AdminMenu> adminMenuList = param.getMenuIds().stream().map(item -> {
            final AdminMenu adminMenu = new AdminMenu();
            adminMenu.setMenuId(item);
            adminMenu.setUserId(param.getId());
            return adminMenu;
        }).collect(Collectors.toList());

        saveBatch(adminMenuList);
    }
}
