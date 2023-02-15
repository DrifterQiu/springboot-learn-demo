package com.example.neo4j.repository;

import com.example.neo4j.entity.King;
import com.example.neo4j.entity.Queen;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 使用Springboot - data - neo4j 生成
 * @author qiuyu
 * @date 2023年02月14日 15:20
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public interface QueenRepository extends Neo4jRepository<Queen,Long> {



}
