package com.zzy.xxx.controller;


import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.controller.common.BaseController;
import com.zzy.xxx.pojo.Pickup;
import com.zzy.xxx.service.PickupService;
import com.zzy.xxx.vo.PickupParam;
import com.zzy.xxx.vo.PickupVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 取件(寄件中心)信息表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/pickup")
public class PickupController extends BaseController {

    private final PickupService pickupService;

    /**
     * 分页条件查询寄件中心信息
     */
    @PostMapping("/page")
    public CommonResult<PageResult<PickupVo>> pickupPage(@RequestBody PickupParam param) {
        log.info("分页条件查询寄件中心，参数：{}", param);
        if (getRoleIdFromToken() == 3) {
            param.setUserId(getUserIdFromToken());
        }
        final PageResult<PickupVo> result = pickupService.pickupPage(param);
        return success(result);
    }

    /**
     * 用户寄件
     */
    @PostMapping("/user/add")
    public CommonResult<Void> userSender(@RequestBody Pickup pickup) {
        final Long userId = getUserIdFromToken();
        pickup.setUserId(userId);
        log.info("用户寄件，参数：{}", pickup);

        pickupService.userSender(pickup);
        return success();
    }

    /**
     * 管理员寄出快递
     */
    @PostMapping("/admin/add")
    public CommonResult<Void> adminSender(@RequestBody Pickup pickup) {
        log.info("管理员寄出快递，参数：{}",pickup);
        pickupService.adminSender(pickup);
        return success();
    }

    /**
     * 修改快递信息
     */
    @PutMapping("/update")
    public CommonResult<Void> update(@RequestBody Pickup pickup) {
        log.info("修改快递信息，参数：{}",pickup);
        pickupService.updateById(pickup);
        return success();
    }

    /**
     * 删除快递信息
     */
    @DeleteMapping("/{id}")
    public CommonResult<Void> delete(@PathVariable Long id) {
        log.info("删除快递信息，参数:{}", id);
        pickupService.removeById(id);
        return success();
    }

    /**
     * 无人机取件
     */
    @PostMapping("/drone/{droneId}/{expressId}")
    public CommonResult<Void> dronePickup(@PathVariable Long droneId,
                                          @PathVariable Long expressId) {
        log.info("无人机取件，参数：{}，{}",droneId,expressId);
        pickupService.dronePickup(droneId,expressId);
        return success();
    }
}
