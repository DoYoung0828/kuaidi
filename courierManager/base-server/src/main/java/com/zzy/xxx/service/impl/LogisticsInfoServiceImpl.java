package com.zzy.xxx.service.impl;

import com.zzy.xxx.pojo.LogisticsInfo;
import com.zzy.xxx.mapper.LogisticsInfoMapper;
import com.zzy.xxx.service.LogisticsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 物流信息表，用于存储快递物流状态信息 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Service
public class LogisticsInfoServiceImpl extends ServiceImpl<LogisticsInfoMapper, LogisticsInfo> implements LogisticsInfoService {

}
