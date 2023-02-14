package com.example.jpa.test;

import com.example.jpa.entity.Goods;
import com.example.jpa.entity.OrderFrom;
import com.example.jpa.repository.OrderFromRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;


/**
 * @author qiuyu
 * @date 2022年08月25日 23:04
 */
//@SpringBootTest(classes = JpaApplication.class)
@DataJpaTest //具有事务性，会自动回滚插入数据
@AutoConfigureTestDatabase(replace = Replace.NONE)  //不采用默认的是嵌入的 H2 数据库
public class OrderFromRepositoryTest {

    @Autowired
    private OrderFromRepository orderFromRepository;

    @Test
    @Rollback(false)
    public void testC(){
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods("商品1"));
        goodsList.add(new Goods("商品2"));
        OrderFrom orderFrom = new OrderFrom();
        orderFrom.setState(1);
        orderFrom.setGoodsList(goodsList);
        orderFromRepository.save(orderFrom);
    }

    @Test
    @Rollback(false)
    public void testD(){
        orderFromRepository.deleteById(1L);
    }

}
