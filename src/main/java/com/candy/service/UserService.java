package com.candy.service;


import com.candy.pojo.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);

    void add(User user);

    User selectById(Integer id);

    void update(User user);

    void delete(Integer id);
}
