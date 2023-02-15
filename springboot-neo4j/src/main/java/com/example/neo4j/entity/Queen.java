package com.example.neo4j.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;

/**
 * @author qiuyu
 * @date 2023年02月14日 15:13
 */
public class Queen implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名字
     */
    private String name;
    /**
     * 家系：家族关系
     */
    private String clan;
    /**
     * 年号：生活的时代
     */
    private String times;
    /**
     * 庙号：君主于庙中被供奉时所称呼的名号
     */
    private String TempleNumber;
    /**
     * 谥号：人死之后，后人给予评价
     */
    private String posthumousTitle;
    /**
     * 陵墓
     */
    private String son;
    /**
     * 备注
     */
    private String remark;

    /**
     * 关系指向自己
     */
    @Relationship(type = "皇后", direction = Relationship.INCOMING)
    private King king;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getTempleNumber() {
        return TempleNumber;
    }

    public void setTempleNumber(String templeNumber) {
        TempleNumber = templeNumber;
    }

    public String getPosthumousTitle() {
        return posthumousTitle;
    }

    public void setPosthumousTitle(String posthumousTitle) {
        this.posthumousTitle = posthumousTitle;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }
}
