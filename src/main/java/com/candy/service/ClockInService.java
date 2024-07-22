package com.candy.service;

import com.candy.pojo.Action;
import com.candy.pojo.ClockIn;
import com.candy.pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ClockInService {
    PageBean page(Integer page, Integer pageSize, String part, LocalDate begin, LocalDate end);

    void add(LocalDate date, LocalTime takeTime, String part);

    ClockIn getById(Integer id);

    void update(ClockIn clockIn);

    void delete(List<Integer> ids);
}
