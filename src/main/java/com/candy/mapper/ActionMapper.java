package com.candy.mapper;

import com.candy.pojo.Action;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ActionMapper {
    /**
     * 根据部位查询全部动作数据
     * @return
     */
//    @Select("select * from action_tb ORDER BY id desc")
    List<Action> list(String part);

    /**
     * 添加动作
     * @param action
     * @param partId
     * @param image
     */
    @Insert("insert INTO action_tb(action,part_id,image,create_time,update_time) " +
            "VALUES(#{action},#{partId},#{image},NOW(),NOW())")
    void add(String action,Integer partId,String image);

    /**
     * 根据id查询动作
     * @param id
     */
    @Select("SELECT t2.id,action,part,image,t2.create_time,t2.update_time " +
            "from part_tb t1,action_tb t2 WHERE t1.id=t2.part_id and t2.id=#{id}")
    Action getById(Integer id);

    /**
     * 根据id修改动作
     * @param id
     * @param action
     * @param partId
     * @param image
     */
    @Update("update action_tb set action=#{action},part_id=#{partId},image=#{image}," +
            "update_time=now() where id = #{id}")
    void update(Integer id,String action,Integer partId,String image);

    /**
     * 根据ids批量删除动作
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 根据动作查询id
     * @param action
     * @return
     */
    @Select("SELECT id from action_tb where action = #{action} ")
    Integer getByAction(String action);
}
