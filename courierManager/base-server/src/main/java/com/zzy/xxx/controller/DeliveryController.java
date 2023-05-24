package com.zzy.xxx.controller;


import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.controller.common.BaseController;
import com.zzy.xxx.pojo.Delivery;
import com.zzy.xxx.service.CarService;
import com.zzy.xxx.service.DeliveryService;
import com.zzy.xxx.vo.DeliveryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 派件信息表(派件中心) 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController extends BaseController {

    private final DeliveryService deliveryService;
    private final CarService carService;

    /**
     * 分页查询派件信息
     */
    @PostMapping("/page")
    public CommonResult<PageResult<Delivery>> pageDeliver(@RequestBody DeliveryParam param) {
        param.setUserId(getUserIdFromToken());
        param.setRoleId(getRoleIdFromToken());
        log.info("分页查询派件信息，参数:{}",param);

        final PageResult<Delivery> deliveryPageResult = deliveryService.pageDeliver(param);
        return success(deliveryPageResult);
    }

    /**
     * 修改派件信息
     */
    @PutMapping("/")
    public CommonResult<Void> update(@RequestBody Delivery delivery) {
        log.info("修改派件信息，参数：{}",delivery);
        deliveryService.updateById(delivery);
        return success();
    }

    /**
     * 删除派件信息
     */
    @DeleteMapping("/{id}")
    public CommonResult<Void> delete(@PathVariable Long id) {
        log.info("删除派件信息，参数:{}",id);
        deliveryService.removeById(id);
        return success();
    }

    /**
     * 点击送达
     */
    @PutMapping("/success")
    public CommonResult<Void> end(@RequestBody Delivery delivery) {
        delivery.setEndTime(LocalDateTime.now());
        log.info("点击送达，参数：{}",delivery);

        deliveryService.updateById(delivery);

        delivery.getCar().setIsIdle(true);
        carService.updateById(delivery.getCar());
        return success();
    }

}
