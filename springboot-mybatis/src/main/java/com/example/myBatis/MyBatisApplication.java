package com.example.myBatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qiuyu
 * @date 2022年08月05日 21:09
 */
@SpringBootApplication(scanBasePackages = {"com.example.myBatis"})
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class,args);
    }
}
