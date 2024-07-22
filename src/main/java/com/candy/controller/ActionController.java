package com.candy.controller;

import com.candy.pojo.Action;
import com.candy.pojo.PageBean;
import com.candy.pojo.Result;
import com.candy.service.ActionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/action")
//@Tag(name = "动作管理接口")
public class ActionController {
    @Autowired
    private ActionService actionService;

    /**
     * 根据ids批量删除动作
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("根据ids删除动作,ids={}",ids);
        actionService.delete(ids);
        return Result.success();
    }

    /**
     * 修改动作数据
     * @param action
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Action action) {
        log.info("根据id修改动作,id={},修改参数:{},{},{}",
                action.getId(),action.getAction(),action.getPart(),action.getImage());
        actionService.update(action);
        return Result.success();
    }

    /**
     * 根据id查询动作
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询动作,id={}",id);
        Action action = actionService.getById(id);
        return Result.success(action);
    }

    /**
     * 添加动作
     * @param action
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Action action) {
        log.info("添加动作,参数:{},{},{}", action.getAction(), action.getPart(), action.getImage());

        actionService.add(action.getAction(), action.getPart(), action.getImage());
        return Result.success();
    }

    /**
     * 分页条件查询动作
     * @param page
     * @param pageSize
     * @param part
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam(defaultValue = "全部") String part) {
        log.info("动作的分页查询,参数:{},{},{}", page, pageSize, part);

        PageBean pageBean = actionService.page(page, pageSize, part);
        return Result.success(pageBean);
    }


}
