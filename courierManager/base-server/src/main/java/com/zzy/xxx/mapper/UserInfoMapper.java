package com.zzy.xxx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.pojo.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.UserParam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Page<UserInfo> selectConditionPage(@Param("queryPage") Page<UserInfo> queryPage, @Param("param") UserParam param);
}
