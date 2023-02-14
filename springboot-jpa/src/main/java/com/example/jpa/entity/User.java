package com.example.jpa.entity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author qiuyu
 * @date 2022年08月05日 21:49
 */
//使用JPA注解配置映射关系
//告诉JPA这是一个实体类（和数据表映射的类）
@Entity
//@Table来指定和那个数据表对应，如果省略默认表明就是user;
@Table(name="user_jpa")
@Data
//生成一个无参数的构造方法
@NoArgsConstructor
//会生成一个包含常量，和标识了NotNull的变量的构造方法。
//@RequiredArgsConstructor
//会生成一个包含所有变量，同时如果变量使用了NotNull annotation ， 会进行是否为空的校验
@AllArgsConstructor
@Builder
public class User implements Serializable {


    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增组件
    private Integer id;

    @Column(name="user_name",length = 50) //这是和数据表对应的一个列
    private String userName;

    @Column(name="password",length = 50)
    private String password;

    @Column(name="sex",length = 50)
    private String sex;

    @Column(name="email",length = 50)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<OrderFrom> orderFroms;


}
