package com.candy.mapper;

import com.candy.pojo.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PartMapper {
    /**
     * 查询所有部位信息
     * @return
     */
    @Select("select * from part_tb")
    List<Part> selectAll();

    /**
     * 根据动作查询动作id
     * @param part
     * @return
     */
    @Select("select id from part_tb WHERE part=#{part}")
    Integer selectByPart(String part);
}
