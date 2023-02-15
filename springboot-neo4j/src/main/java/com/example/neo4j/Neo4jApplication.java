package com.example.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


/**
 * @author qiuyu
 * @date 2022年08月05日 21:09
 */
@SpringBootApplication(scanBasePackages = {"com.example.neo4j"})
public class Neo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class,args);
    }
}
