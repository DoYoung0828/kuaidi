package com.zzy.xxx.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.controller.common.BaseController;
import com.zzy.xxx.pojo.Express;
import com.zzy.xxx.service.ExpressService;
import com.zzy.xxx.vo.ExpressParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 快递表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/express")
public class ExpressController extends BaseController {

    private final ExpressService expressService;

    /**
     * 分页条件查询快递中心订单
     */
    @PostMapping("/page")
    public CommonResult<PageResult<Express>> pageExpress(@RequestBody ExpressParam param) {
        param.setUserId(getUserIdFromToken());
        param.setRoleId(getRoleIdFromToken());
        param.setSiteId(getSiteIdFromToken());
        log.info("分页条件查询快递中心订单，参数:{}", param);

        final PageResult<Express> pageResult = expressService.pageExpress(param);
        return success(pageResult);
    }

    /**
     * 快递入库
     */
    @PostMapping("/add")
    public CommonResult<Void> addExpress(@RequestBody Express express) {
        express.setSiteId(getSiteIdFromToken());
        log.info("快递入库，参数：{}", express);
        express.setExpressNo(DateUtil.format(new Date(), "yyyyMMddHHmmss") + RandomUtil.randomInt(100000, 999999));
        expressService.save(express);
        return success();
    }

    /**
     * 派件无人机接单
     */
    @PutMapping("/out/{id}/{droneId}")
    public CommonResult<Void> outExpress(@PathVariable Long id, @PathVariable Long droneId) {
        log.info("派件无人机接单，参数:{},{}", id, droneId);
        expressService.courierPick(droneId,id, getUserIdFromToken());

        return success();
    }

    /**
     * 修改快递信息
     */
    @PutMapping("/update")
    public CommonResult<Void> updateExpress(@RequestBody Express express) {
        log.info("修改快递信息，参数:{}", express);
        expressService.updateById(express);
        return success();
    }

    /**
     * 删除快递
     */
    @DeleteMapping("/{id}")
    public CommonResult<Void> deleteExpress(@PathVariable Long id) {
        log.info("删除快递，参数:{}", id);
        expressService.removeById(id);
        return success();
    }
}
