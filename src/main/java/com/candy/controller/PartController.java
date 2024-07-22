package com.candy.controller;

import com.candy.pojo.Part;
import com.candy.pojo.Result;
import com.candy.service.PartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/part")
public class PartController {
    @Autowired
    private PartService partService;


    @GetMapping
    public Result list() {
        log.info("查询全部部位信息");
        List<Part> parts = partService.list();
        return Result.success(parts);
    }

}
