package com.example.myBatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myBatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author qiuyu
 * @date 2023年08月31日 21:26
 */

@Mapper
public interface UserMapper{

    /**
     * 查询所有User对象列表
     *
     * @return 用户列表
     */
    @Select("SELECT * FROM user_jpa ")
    List<User> findAll();


    /**
     * 根据姓名查找用户
     *
     * @param name 姓名
     * @return 用户对象
     */
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    /**
     * 根据用户ID查找用户信息
     *
     * @param id 用户ID
     * @return 用户对象
     */
    User findById(@Param("id") Integer id);

    /**
     * 插入用户信息到USER表中
     * @return 插入的行数
     */
    @Insert("INSERT INTO USER(NAME, PASSWORD,SEX,EMAIL) VALUES(#{name}, #{password},#{sex},#{email})")
    int insert(User user);

    /**
     * 更新用户信息
     * SQL 语句：UPDATE USER SET NAME=#{name},PASSWORD=#{password},SEX=#{sex},EMAIL=#{email} WHERE ID=#{id}
     *
     * @param user 要更新的用户对象
     * @return 更新的行数
     */
    @Update("UPDATE USER SET NAME=#{name},PASSWORD=#{password},SEX=#{sex},EMAIL=#{email} WHERE ID=#{id}")
    int update(User user);

    /**
     * 根据ID删除USER表中的记录
     *
     * @param id 要删除的记录的ID
     * @return 删除成功的记录数
     */
    @Delete("DELETE FROM USER WHERE ID=#{id}")
    int deleteById(@Param("id") Integer id);



}
