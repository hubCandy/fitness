package com.candy.mapper;

import com.candy.pojo.Action;
import com.candy.pojo.Detail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.net.Inet4Address;
import java.util.List;

@Mapper
public interface DetailMapper {

    @Select("SELECT t1.id,action,class_num,number,t1.create_time,t1.update_time " +
            "from detail_tb t1,action_tb t2 " +
            "where t1.action_id=t2.id and clockIn_id=#{clockInId} order by t1.id desc")
    List<Detail> list(Integer clockInId);

    @Insert("insert INTO detail_tb(clockIn_id,action_id,class_num,number,create_time,update_time) " +
            "VALUES(#{clockInId},#{actionId},#{classNum},#{number},NOW(),NOW())")
    void add(Integer clockInId, Integer actionId, Integer classNum, Integer number);

    @Select("SELECT t1.id,action,class_num,number,t1.create_time,t1.update_time " +
            "from detail_tb t1,action_tb t2 where t1.action_id=t2.id and t1.id = #{id}")
    Detail getById(Integer id);

    @Update("update detail_tb set action_id=#{actionId},class_num=#{classNum},number=#{number} where id = #{id}")
    void update(Integer id, Integer actionId, Integer classNum, Integer number);

    void delete(List<Integer> ids);

    void deleteByCid(List<Integer> ids);

}
