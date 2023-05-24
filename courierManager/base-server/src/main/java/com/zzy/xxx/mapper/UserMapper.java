package com.zzy.xxx.mapper;

import com.zzy.xxx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.PickStaticsVo;
import com.zzy.xxx.vo.StaticsVo;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface UserMapper extends BaseMapper<User> {

    StaticsVo getStatics();

    List<PickStaticsVo> getPickStatics();
}
