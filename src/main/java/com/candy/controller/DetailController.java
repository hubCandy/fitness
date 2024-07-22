package com.candy.controller;

import com.candy.pojo.Action;
import com.candy.pojo.Detail;
import com.candy.pojo.PageBean;
import com.candy.pojo.Result;
import com.candy.service.ActionService;
import com.candy.service.DetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/detail")
public class DetailController {
    @Autowired
    private DetailService detailService;

    /**
     * 根据ids批量删除动作
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("根据ids删除动作,ids={}",ids);
        detailService.delete(ids);
        return Result.success();
    }

    /**
     * 修改动作数据
     * @param detail
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Detail detail) {
        log.info("根据id修改动作,id={},修改参数:{},{},{}",
                detail.getId(),detail.getAction(),detail.getClassNum(),detail.getNumber());
        detailService.update(detail);
        return Result.success();
    }

    /**
     * 根据id查询详情动作
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询详情动作,id={}",id);
        Detail detail = detailService.getById(id);
        return Result.success(detail);
    }

    /**
     * 添加详情动作
     * @param detail
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Detail detail) {
        log.info("添加详情动作,参数:{},{},{},{}", detail.getClockInId(), detail.getAction(), detail.getClassNum(),detail.getNumber());

        detailService.add(detail);
        return Result.success();
    }

    /**
     * 查询详情动作
     * @param id
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer id) {
        log.info("详情动作的查询,参数:clockInId:{}",id);

        List<Detail> details = detailService.page(id);
        return Result.success(details);
    }


}
