package com.zzy.xxx.controller;


import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.controller.common.BaseController;
import com.zzy.xxx.pojo.Delivery;
import com.zzy.xxx.pojo.ReturnGoods;
import com.zzy.xxx.service.ReturnGoodsService;
import com.zzy.xxx.vo.DeliveryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/return-goods")
public class ReturnGoodsController extends BaseController {

    private final ReturnGoodsService returnGoodsService;

    /**
     * 申请退货
     */
    @PutMapping("/")
    public CommonResult<Void> returnGoods(@RequestBody Delivery delivery) {
        log.info("申请退货，参数：{}", delivery);
        returnGoodsService.returnGoods(delivery);
        return success();
    }

    /**
     * 分页查询退款信息
     */
    @PostMapping("/page")
    public CommonResult<PageResult<ReturnGoods>> pageReturn(@RequestBody DeliveryParam param) {
        param.setUserId(getUserIdFromToken());
        param.setRoleId(getRoleIdFromToken());
        log.info("分页查询退款信息，参数:{}",param);

        final PageResult<ReturnGoods> deliveryPageResult = returnGoodsService.pageReturn(param);
        return success(deliveryPageResult);
    }

    /**
     * 编辑退货信息
     */
    @PutMapping("/update")
    public CommonResult<Void> updateInfo(@RequestBody ReturnGoods returnGoods) {
        log.info("编辑退货信息，参数:{}", returnGoods);
        returnGoodsService.updateById(returnGoods);
        return success();
    }

    /**
     * 删除退货信息
     */
    @DeleteMapping("/{id}")
    public CommonResult<Void> deleteById(@PathVariable Long id) {
        log.info("删除退货信息，参数:{}", id);
        returnGoodsService.removeById(id);
        return success();
    }
}
