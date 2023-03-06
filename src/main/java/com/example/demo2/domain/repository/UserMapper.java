package com.example.demo2.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.example.demo2.domain.model.User;

@Mapper
public interface UserMapper {
    // ユーザー一覧取得
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findOneById(@Param("id") int id);

    @Insert("insert into user(name, mail_address) values( #{name}, #{mailAddress} )")
    int insertOne(@Param("name") String name, @Param("mailAddress") String mailAddress);

    @Update("update user set name = #{userName}, mail_address = #{mailAddress} where id = #{userId}")
    int updateOne(@Param("userId") int id, @Param("userName") String userName, @Param("mailAddress") String mailAddress);

    @Delete("delete from user where id = #{id}")
    int deleteOne(@Param("id") int id);
}
