package com.example.demo2.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.example.demo2.domain.model.User;

@Mapper
public interface UserMapper {
    // ユーザー一覧取得
    @Select("select * from user")
    List<User> findAll();

    // ユーザー１人取得
    @Select("select * from user where id = #{id}")
    User findOneById(@Param("id") int id);

    // userテーブル行数取得
    @Select("select count(id) from user")
    long numOfRows();

    /**
     * 指定ページのユーザーリスト取得
     * @param numPerPage ページ番号
     * @param offset 1ページあたりユーザー数
     */
    @Select("select * from user limit #{numPerPage} offset #{offset}")
    List<User> findUsersByPageNo(@Param("numPerPage") long numPerPage, @Param("offset") long offset);

    @Insert("insert into user(name, mail_address) values( #{name}, #{mailAddress} )")
    int insertOne(@Param("name") String name, @Param("mailAddress") String mailAddress);

    @Insert("insert into user(name, mail_address, pict_path) values( #{name}, #{mailAddress}, #{pictPath} )")
    int insertOneWithPict(@Param("name") String name, @Param("mailAddress") String mailAddress, @Param("pictPath") String pictPath);

    @Update("update user set name = #{userName}, mail_address = #{mailAddress} where id = #{userId}")
    int updateOne(@Param("userId") int id, @Param("userName") String userName, @Param("mailAddress") String mailAddress);

    @Delete("delete from user where id = #{id}")
    int deleteOne(@Param("id") int id);
}
