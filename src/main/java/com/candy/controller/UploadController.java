package com.candy.controller;


import com.candy.pojo.Result;
import com.candy.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin
public class UploadController {
    @Autowired
    AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        log.info("文件上传:{}",image.getOriginalFilename());
        // 上传阿里oss,获取图片网页的资源路径
        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功,url:{}",url);
        return Result.success(url);

    }



//    本地存储
//    @PostMapping("/upload")
//    public Result upload(MultipartFile image) throws Exception {
//        log.info("文件上传: {}",image);
//        //获取原文件名
//        String originalFilename = image.getOriginalFilename();
//
//        //构建唯一名称文件
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//
//        //将文件存储在本地
//        String path = "D:\\360MoveData\\Users\\31834\\Desktop\\临时的图片文件\\" + newFileName;
//        image.transferTo(new File(path));
//        return Result.success(path);
//
//    }


}
