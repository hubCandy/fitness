package com.candy.mapper;

import com.candy.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user_tb where username=#{username} and password=#{password}")
    User login(String username, String password);

    @Insert("insert INTO user_tb(username,password,name,sex,age,email,create_time,update_time) VALUES" +
            "(#{username},#{password},#{name},#{sex},#{age},#{email},NOW(),NOW())")
    void add(String username, String password, String name, String sex, Integer age, String email);

    @Select("select * from user_tb where id=#{id}")
    User selectById(Integer id);

    @Update("update user_tb set username=#{username},password=#{password},name=#{name},sex=#{sex}," +
            "age=#{age},email=#{email} where id = #{id}")
    void update(Integer id, String username, String password, String name, String sex, Integer age, String email);

    @Delete("delete from user_tb where id = #{id}")
    void delete(Integer id);
}
