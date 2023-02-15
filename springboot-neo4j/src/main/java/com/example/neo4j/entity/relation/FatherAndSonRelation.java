package com.example.neo4j.entity.relation;

import com.example.neo4j.entity.King;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * 父子关系实体
 * @author qiuyu
 * @date 2023年02月14日 15:04
 */
@RelationshipEntity(type = "father_son")  //连接节点 可用于所有不是简单类型的属性
public class FatherAndSonRelation {

    @Id
    private long id;

    @StartNode
    private King from;

    @EndNode
    private King to;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public King getFrom() {
        return from;
    }

    public void setFrom(King from) {
        this.from = from;
    }

    public King getTo() {
        return to;
    }

    public void setTo(King to) {
        this.to = to;
    }
}
