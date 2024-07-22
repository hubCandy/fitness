package com.candy.service.impl;

import com.candy.mapper.ActionMapper;
import com.candy.mapper.DetailMapper;
import com.candy.mapper.PartMapper;
import com.candy.pojo.Detail;
import com.candy.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailMapper detailMapper;
    @Autowired
    private ActionMapper actionMapper;


    @Override
    public List<Detail> page(Integer ClockInId) {
        //1. 执行查询
        List<Detail> details = detailMapper.list(ClockInId);
        return details;

    }

    @Override
    public void add(Detail detail) {
        //1. 获取 actionId
        Integer actionId = actionMapper.getByAction(detail.getAction());
        //2. 添加到数据库
        detailMapper.add(detail.getClockInId(),actionId,detail.getClassNum(),detail.getNumber());
    }

    @Override
    public Detail getById(Integer id) {
        return detailMapper.getById(id);
    }

    @Override
    public void update(Detail detail) {
        Integer actionId = actionMapper.getByAction(detail.getAction());
        detailMapper.update(detail.getId(), actionId, detail.getClassNum(), detail.getNumber());
    }

    @Override
    public void delete(List<Integer> ids) {
        detailMapper.delete(ids);

    }

}
