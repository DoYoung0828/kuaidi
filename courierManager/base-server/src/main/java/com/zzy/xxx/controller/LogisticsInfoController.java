package com.zzy.xxx.controller;


import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.pojo.LogisticsInfo;
import com.zzy.xxx.service.LogisticsInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 物流信息表，用于存储快递物流状态信息 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/logistics-info")
public class LogisticsInfoController {

    private final LogisticsInfoService logisticsInfoService;

    /**
     * 新增或编辑物流信息
     */
    @PostMapping("/update")
    public CommonResult<Void> addOrUpdate(@RequestBody LogisticsInfo logisticsInfo) {
        log.info("新增或编辑物流信息，参数：{}",logisticsInfo);
        logisticsInfoService.saveOrUpdate(logisticsInfo);
        return success();
    }
}
