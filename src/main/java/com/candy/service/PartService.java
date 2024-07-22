package com.candy.service;

import com.candy.pojo.Part;

import java.util.List;

public interface PartService {
    /**
     * 查询所有部位信息
     * @return
     */
    List<Part> list();
}
