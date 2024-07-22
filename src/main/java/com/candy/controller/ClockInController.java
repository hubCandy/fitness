package com.candy.controller;

import com.candy.pojo.Action;
import com.candy.pojo.ClockIn;
import com.candy.pojo.PageBean;
import com.candy.pojo.Result;
import com.candy.service.ActionService;
import com.candy.service.ClockInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/clockIn")
public class ClockInController {
    @Autowired
    private ClockInService clockInService;

    /**
     * 根据ids批量删除打卡
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("根据ids删除打卡数据,ids={}",ids);
        clockInService.delete(ids);
        return Result.success();
    }


    /**
     * 修改打卡数据
     *
     * @param clockIn
     * @return
     */
    @PutMapping
    public Result update(@RequestBody ClockIn clockIn) {
        log.info("根据id修改打卡,id={},修改参数:{},{},{}",
                clockIn.getId(), clockIn.getDate(), clockIn.getTakeTime(), clockIn.getPart());
        clockInService.update(clockIn);
        return Result.success();
    }

    /**
     * 根据id查询打卡数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询动作,id={}", id);
        ClockIn clockIn = clockInService.getById(id);
        return Result.success(clockIn);
    }

    /**
     * 添加打卡
     *
     * @param clockIn
     * @return
     */
    @PostMapping
    public Result add(@RequestBody ClockIn clockIn) {
        log.info("添加动作,参数:{},{},{}", clockIn.getDate(), clockIn.getTakeTime(), clockIn.getPart());

        clockInService.add(clockIn.getDate(), clockIn.getTakeTime(), clockIn.getPart());
        return Result.success();
    }

    /**
     * 分页条件查询打卡
     *
     * @param page
     * @param pageSize
     * @param part
     * @param begin
     * @param end
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam(defaultValue = "全部") String part,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("打卡的分页查询,参数:{},{},{},{},{}", page, pageSize, part, begin, end);

        PageBean pageBean = clockInService.page(page, pageSize, part, begin, end);
        return Result.success(pageBean);
    }


}
