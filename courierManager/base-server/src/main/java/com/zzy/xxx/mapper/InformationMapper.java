package com.zzy.xxx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.pojo.Information;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.InformationParam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 咨询表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface InformationMapper extends BaseMapper<Information> {

    Page<Information> pageInformation(@Param("queryPage") Page<Information> queryPage, @Param("param") InformationParam param);
}
