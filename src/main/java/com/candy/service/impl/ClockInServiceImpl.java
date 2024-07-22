package com.candy.service.impl;

import com.candy.mapper.ActionMapper;
import com.candy.mapper.ClockInMapper;
import com.candy.mapper.DetailMapper;
import com.candy.mapper.PartMapper;
import com.candy.pojo.Action;
import com.candy.pojo.ClockIn;
import com.candy.pojo.PageBean;
import com.candy.service.ClockInService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ClockInServiceImpl implements ClockInService {
    @Autowired
    private ClockInMapper clockInMapper;
    @Autowired
    private PartMapper partMapper;
    @Autowired
    private DetailMapper detailMapper;



    @Override
    public PageBean page(Integer page, Integer pageSize, String part, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<ClockIn> clockIns = clockInMapper.list(part,begin,end);
        Page<ClockIn> p = (Page<ClockIn>) clockIns;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void add(LocalDate date, LocalTime takeTime, String part) {
        //1. 获取partId
        Integer partId = partMapper.selectByPart(part);
        //2. 添加到数据库
        clockInMapper.add(date, takeTime, partId);
    }

    @Override
    public ClockIn getById(Integer id) {
        return clockInMapper.getById(id);
    }

    @Override
    public void update(ClockIn clockIn) {
        Integer partId = partMapper.selectByPart(clockIn.getPart());
        clockInMapper.update(clockIn.getId(), clockIn.getDate(), clockIn.getTakeTime(), partId);
    }

    @Override
    public void delete(List<Integer> ids) {
        //1. 删除打卡记录的内容
        detailMapper.deleteByCid(ids);
        //2. 删除打卡记录
        clockInMapper.delete(ids);
    }

}
