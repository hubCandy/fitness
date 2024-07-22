package com.candy.service;

import com.candy.pojo.Detail;
import com.candy.pojo.PageBean;

import java.util.List;

public interface DetailService {
    List<Detail> page(Integer ClockInId);

    void add(Detail detail);

    Detail getById(Integer id);

    void update(Detail Detail);

    void delete(List<Integer> ids);
}
