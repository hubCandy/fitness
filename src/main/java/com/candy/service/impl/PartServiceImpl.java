package com.candy.service.impl;

import com.candy.mapper.PartMapper;
import com.candy.pojo.Part;
import com.candy.service.ActionService;
import com.candy.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartMapper partMapper;

    @Override
    public List<Part> list() {
        return partMapper.selectAll();
    }
}
