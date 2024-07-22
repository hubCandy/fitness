package com.candy.service.impl;

import com.candy.mapper.ActionMapper;
import com.candy.mapper.PartMapper;
import com.candy.pojo.Action;
import com.candy.pojo.PageBean;
import com.candy.pojo.Part;
import com.candy.service.ActionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private PartMapper partMapper;


    @Override
    public PageBean page(Integer page, Integer pageSize, String part) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Action> actions = actionMapper.list(part);
        Page<Action> p = (Page<Action>) actions;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void add(String action, String part, String image) {
        //1. 获取partId
        Integer partId = partMapper.selectByPart(part);
        //2. 添加到数据库
        actionMapper.add(action, partId, image);
    }

    @Override
    public Action getById(Integer id) {
        return actionMapper.getById(id);
    }

    @Override
    public void update(Action action) {
        Integer partId = partMapper.selectByPart(action.getPart());
        actionMapper.update(action.getId(), action.getAction(), partId, action.getImage());
    }

    @Override
    public void delete(List<Integer> ids) {
        actionMapper.delete(ids);
    }

}
