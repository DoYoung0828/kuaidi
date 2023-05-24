package com.zzy.xxx.controller;

import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.pojo.Information;
import com.zzy.xxx.service.InformationService;
import com.zzy.xxx.vo.InformationParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 资讯表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/information")
public class InformationController {

    private final InformationService informationService;

    /**
     * 分页条件查询资讯
     */
    @PostMapping("/page")
    public CommonResult<PageResult<Information>> pageInformation(@RequestBody InformationParam param) {
        log.info("分页条件查询资讯，参数：{}", param);
        final PageResult<Information> pageResult = informationService.pageInformation(param);
        return success(pageResult);
    }

    /**
     * 新增资讯
     */
    @PostMapping("/add")
    public CommonResult<Void> add(@RequestBody Information information) {
        log.info("新增资讯，参数：{}",information);
        informationService.save(information);
        return success();
    }

    /**
     * 修改咨询
     */
    @PutMapping("/update")
    public CommonResult<Void> update(@RequestBody Information information) {
        log.info("修改咨询，参数:{}", information);
        informationService.updateById(information);
        return success();
    }

    /**
     * 删除咨询
     */
    @DeleteMapping("/{id}")
    public CommonResult<Void> delete(@PathVariable Long id) {
        log.info("删除资讯，参数：{}", id);
        informationService.removeById(id);
        return success();
    }
}
