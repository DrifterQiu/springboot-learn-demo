package com.example.jpa.repository;

import com.example.jpa.entity.OrderFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qiuyu
 * @date 2022年08月25日 23:03
 */
@Repository
public interface OrderFromRepository extends JpaRepository<OrderFrom,Long>{
}
