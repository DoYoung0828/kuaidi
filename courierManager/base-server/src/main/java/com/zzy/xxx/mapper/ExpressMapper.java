package com.zzy.xxx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.pojo.Express;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.xxx.vo.ExpressParam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 快递表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface ExpressMapper extends BaseMapper<Express> {

    /**
     * 分页查询快递中心
     *
     * @param queryPage 分页参数
     * @param param     查询参数
     * @return 查询结果
     */
    Page<Express> pageExpress(@Param("queryPage") Page<Express> queryPage, @Param("param") ExpressParam param);
}
