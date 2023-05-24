package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Information;
import com.zzy.xxx.mapper.InformationMapper;
import com.zzy.xxx.service.InformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.vo.InformationParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 咨询表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@RequiredArgsConstructor
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements InformationService {

    private final InformationMapper informationMapper;

    /**
     * 分页条件查询资讯信息
     *
     * @param param 查询参数
     * @return 查询结果
     */
    @Override
    public PageResult<Information> pageInformation(InformationParam param) {
        final Page<Information> queryPage = new Page<>(param.getPageNo(), param.getPageSize());
        final Page<Information> resultPage = informationMapper.pageInformation(queryPage, param);
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }
}
