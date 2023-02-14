package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * @author qiuyu
 * @date 2022年08月05日 21:09
 */
@SpringBootApplication(scanBasePackages = {"com.example.jpa"})
//开启Defining Query Method（DQM）语法
@EnableJpaRepositories(queryLookupStrategy= QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class,args);
    }
}
