package com.candy.controller;


import com.candy.pojo.ClockIn;
import com.candy.pojo.Result;
import com.candy.pojo.User;
import com.candy.service.UserService;
import com.candy.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除用户,id={}",id);
        userService.delete(id);
        return Result.success();
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/user")
    public Result update(@RequestBody User user) {
        log.info("根据id修改用户信息:{}",user);
        userService.update(user);
        return Result.success();

    }

    /**
     * 查看令牌是否生效
     * @param request
     * @return
     */
    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest request) {
        log.info("开始解析令牌...");
        String jwt = request.getHeader("token");
        log.info("令牌:{}",jwt);
        if (jwt == null) {
            return false;
        }
        //Jwt令牌存在, 解析令牌
        try {
            Claims claims = JwtUtils.parseJWT(jwt);
            Object username = claims.get("username");
            log.info("令牌解析,username:{}",username);
        } catch (Exception e) {
            // 解析失败
            return false;
        }
        log.info("解析成功,令牌生效");
        return true;

    }

    /**
     * 返回用户信息
     * @param token
     * @return
     */
    @GetMapping("/user")
    public Result getUser(String token) {
        //解析令牌, 获取用户id
        Claims claims = JwtUtils.parseJWT(token);
        Integer id = (Integer)claims.get("id");
        //根据id获取用户信息
        User user = userService.selectById(id);
        return Result.success(user);
    }


}
