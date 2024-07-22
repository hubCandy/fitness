package com.candy.controller;


import com.candy.pojo.Result;
import com.candy.pojo.User;
import com.candy.service.UserService;
import com.candy.utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        log.info("用户信息:{}", user);

        userService.add(user);
        return Result.success();
    }


    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletResponse response) {
        log.info("用户名:{},密码:{}", user.getUsername(), user.getPassword());

        User login = userService.login(user.getUsername(), user.getPassword());
        if (login != null) {
            //登录成功,下发令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",login.getId());
            claims.put("name",login.getName());
            claims.put("username",login.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }



}
