package com.example.neo4j.repository;

import com.example.neo4j.entity.King;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 使用Springboot - data - neo4j 生成
 * @author qiuyu
 * @date 2023年02月14日 15:20
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public interface KingRepository extends Neo4jRepository<King,Long> {

    /**
     * 通过名字查找King
     *
     * @param name
     * @return
     */
    King findByName(String name);


    /**
     * 获取当前节点下的所有king
     *
     * @param name
     * @return
     */
    @Query("match p=(a:King)-[r:`传位`*0..]->(b:King) where a.name={0} return p")
    List<King> getKings(String name);

    /**
     * 通过皇帝名字查询到当前皇帝皇后以及上一任皇帝皇后
     */
    @Query("match p=(a:King)-[r:`传位`]->(b:King)-[r2:`皇后`*1..]->(c:Queen) where a.name={0} return p")
    Iterator<Map<String, Object>> getBeforeAndNow(String name);
}
