package com.candy.service;

import com.candy.pojo.Action;
import com.candy.pojo.PageBean;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ActionService {
    PageBean page(Integer page, Integer pageSize, String part);

    void add(String action, String part, String image);

    Action getById(Integer id);

    void update(Action action);

    void delete(List<Integer> ids);
}
