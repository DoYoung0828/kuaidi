package com.zzy.xxx.controller;

import com.zzy.xxx.common.CommonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static com.zzy.xxx.common.CommonResult.success;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 文件上传
 * @author: zzy
 * @date: 2023/3/12
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value("${server.port}")
    private String port;

    private final String imgFileLocation = "D:" + File.separator + "pro_img" + File.separator;

    @ApiOperation("上传图片")
    @PostMapping("/img")
    @CrossOrigin
    public CommonResult<String> uploadImg(MultipartFile file) throws IOException {
        log.info("uploadImg START file:{}", file);

        // 生成文件名
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatNow = simpleDateFormat.format(new Date());
        String fileName = formatNow + System.currentTimeMillis()
                + UUID.randomUUID().toString().substring(0, 4)
                + Objects.requireNonNull(file.getOriginalFilename())
                .substring(file.getOriginalFilename().lastIndexOf("."));

        // 生成本地文件
        File dest = new File(imgFileLocation);
        if (!dest.exists()) {
            dest.mkdir();
        }
        file.transferTo(Path.of(imgFileLocation + fileName));

        // 转换为网络地址
        fileName = "http://localhost:" + port + "/common/img/" + fileName;

        log.info("上传图片成功， 图片名称:{}", fileName);
        return success(fileName);
    }
}
