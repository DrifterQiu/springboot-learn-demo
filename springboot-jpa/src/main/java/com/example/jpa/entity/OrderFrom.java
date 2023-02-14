package com.example.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * @author qiuyu
 * @date 2022年08月25日 22:42
 */
@Entity
@Table(name="order_from_jpa")
@Data
@NoArgsConstructor
public class OrderFrom implements Serializable {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增组件
    private Long id;

    @Column(name="state")
    private Integer state;


    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "orderfrom_goods_jpa",
            joinColumns = @JoinColumn(name = "order_from_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    private List<Goods> goodsList;

}
