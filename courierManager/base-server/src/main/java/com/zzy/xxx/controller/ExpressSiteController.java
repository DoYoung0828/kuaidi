package com.zzy.xxx.controller;


import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.pojo.ExpressSite;
import com.zzy.xxx.service.ExpressService;
import com.zzy.xxx.service.ExpressSiteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-05-05
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/express-site")
public class ExpressSiteController {

    private final ExpressSiteService expressSiteService;

    /**
     * 查询所有站点信息
     */
    @GetMapping("/all")
    public CommonResult<List<ExpressSite>> getAll() {
        log.info("查询所有站点信息");
        return success(expressSiteService.list());
    }
}
