package com.zzy.xxx.mapper;

import com.zzy.xxx.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectByRoleId(Long roleId);

}
