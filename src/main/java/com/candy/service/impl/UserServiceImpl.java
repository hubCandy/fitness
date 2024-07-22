package com.candy.service.impl;

import com.candy.mapper.ActionMapper;
import com.candy.mapper.PartMapper;
import com.candy.mapper.UserMapper;
import com.candy.pojo.Action;
import com.candy.pojo.PageBean;
import com.candy.pojo.User;
import com.candy.service.ActionService;
import com.candy.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public void add(User user) {
        userMapper.add(user.getUsername(), user.getPassword(), user.getName(),
                user.getSex(), user.getAge(), user.getEmail());
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user.getId(), user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getEmail());
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }
}
