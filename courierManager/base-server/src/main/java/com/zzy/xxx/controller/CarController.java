package com.zzy.xxx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.xxx.common.CommonResult;
import com.zzy.xxx.common.PageResult;
import com.zzy.xxx.controller.common.BaseController;
import com.zzy.xxx.pojo.Car;
import com.zzy.xxx.service.CarService;
import com.zzy.xxx.vo.CarParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * <p>
 * 无人机表 前端控制器
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController extends BaseController {

    private final CarService carService;

    /**
     * 分页查询无人机信息
     */
    @PostMapping("/page")
    public CommonResult<PageResult<Car>> carPage(@RequestBody CarParam param) {
        param.setUserId(getUserIdFromToken());
        log.info("分页查询无人机信息，参数：{}",param);
        final PageResult<Car> carPageResult = carService.carPage(param);
        return success(carPageResult);
    }

    /**
     * 新增无人机
     */
    @PostMapping("/")
    public CommonResult<Void> add(@RequestBody Car car) {
        car.setUserId(getUserIdFromToken());
        log.info("新增无人机，参数：{}",car);
        carService.save(car);
        return success();
    }

    /**
     * 编辑无人机
     */
    @PutMapping("/")
    public CommonResult<Void> update(@RequestBody Car car) {
        log.info("编辑无人机，参数：{}",car);
        carService.updateById(car);
        return success();
    }

    /**
     * 删除无人机
     */
    @DeleteMapping("/{id}")
    public CommonResult<Void> delete(@PathVariable Long id) {
        log.info("删除无人机，参数：{}",id);
        carService.removeById(id);
        return success();
    }

    /**
     * 根据用户id查询空闲无人机
     */
    @GetMapping("/user")
    public CommonResult<List<Car>> selectByUserId() {
        final Long id = getUserIdFromToken();
        log.info("根据用户id查询空闲无人机，参数：{}", id);

        final List<Car> carList = carService.list(
                new QueryWrapper<Car>()
                        .eq("user_id", id)
                        .eq("is_idle", 1));

        return success(carList);
    }
}
