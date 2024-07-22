package com.candy.mapper;

import com.candy.pojo.Action;
import com.candy.pojo.ClockIn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Mapper
public interface ClockInMapper {

    List<ClockIn> list(String part, LocalDate begin, LocalDate end);

    @Insert("insert INTO clockin_tb(date,take_time,part_id,create_time,update_time) VALUES(#{date},#{takeTime},#{partId},NOW(),NOW())")
    void add(LocalDate date, LocalTime takeTime, Integer partId);

    @Select("SELECT t1.id,date,take_time,part,t1.create_time,t1.update_time from clockin_tb t1,part_tb t2 " +
            "where t1.part_id=t2.id and t1.id = #{id}")
    ClockIn getById(Integer id);

    @Update("update clockin_tb set date=#{date},take_time=#{takeTime},part_id=#{partId} where id = #{id}")
    void update(Integer id, LocalDate date, LocalTime takeTime, Integer partId);


    void delete(List<Integer> ids);
}
