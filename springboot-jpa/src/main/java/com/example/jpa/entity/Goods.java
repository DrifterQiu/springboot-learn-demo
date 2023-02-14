package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author qiuyu
 * @date 2022年08月25日 22:44
 */
@Entity
@Table(name="goods_jpa")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Goods implements Serializable {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增组件
    private Long id;

    @Column(name="goods_Name",length = 50)
    private String goodsName;

//    @ManyToMany(mappedBy = "goods")
//    private List<OrderFrom> orderFromList;

    public Goods(String goodsName) {
        this.goodsName = goodsName;
    }
}
