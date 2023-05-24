package com.zzy.xxx.service;

import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Information;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzy.xxx.vo.InformationParam;

/**
 * <p>
 * 咨询表 服务类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
public interface InformationService extends IService<Information> {

    /**
     * 分页条件查询资讯信息
     *
     * @param param 查询参数
     * @return 查询结果
     */
    PageResult<Information> pageInformation(InformationParam param);
}
