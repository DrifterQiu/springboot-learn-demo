package com.example.myBatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author qiuyu
 * @date 2022年08月05日 21:49
 */
//@Table来指定和那个数据表对应，如果省略默认表明就是user;
@TableName("user_jpa")
@Data
//生成一个无参数的构造方法
@NoArgsConstructor
//会生成一个包含常量，和标识了NotNull的变量的构造方法。
//@RequiredArgsConstructor
//会生成一个包含所有变量，同时如果变量使用了NotNull annotation ， 会进行是否为空的校验
@AllArgsConstructor
@Builder
public class User implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //@Column(name="user_name",length = 50) //这是和数据表对应的一个列
    private String userName;

    //@Column(name="password",length = 50)
    private String password;

    //@Column(name="sex",length = 50)
    private String sex;

    //@Column(name="email",length = 50)
    private String email;



}
