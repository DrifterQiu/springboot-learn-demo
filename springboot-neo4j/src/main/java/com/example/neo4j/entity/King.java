package com.example.neo4j.entity;

import com.example.neo4j.entity.relation.FatherAndSonRelation;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuyu
 * @date 2023年02月14日 15:00
 */
public class King implements Serializable {

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
     * 谥号：人死之后，后人给予评价
     */
    private String posthumousTitle;
    /**
     * 庙号：君主于庙中被供奉时所称呼的名号
     */
    private String TempleNumber;
    /**
     * 陵墓
     */
    private String tomb;
    /**
     * 大事件
     */
    private String remark;

    @Relationship(type = "传位")
    King successor;

    /**
     * 第二种保存关系的方式
     */
    @Relationship
    List<FatherAndSonRelation> sons;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPosthumousTitle() {
        return posthumousTitle;
    }

    public void setPosthumousTitle(String posthumousTitle) {
        this.posthumousTitle = posthumousTitle;
    }

    public String getTempleNumber() {
        return TempleNumber;
    }

    public void setTempleNumber(String templeNumber) {
        TempleNumber = templeNumber;
    }

    public String getTomb() {
        return tomb;
    }

    public void setTomb(String tomb) {
        this.tomb = tomb;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public King getSuccessor() {
        return successor;
    }

    public void setSuccessor(King successor) {
        this.successor = successor;
    }

    public List<FatherAndSonRelation> getSons() {
        return sons;
    }

    public void setSons(List<FatherAndSonRelation> sons) {
        this.sons = sons;
    }

    /**
     * 添加友谊的关系
     * @param
     */
    public void addRelation(FatherAndSonRelation fatherAndSonRelation){
        if(this.sons == null){
            this.sons = new ArrayList<>();
        }
        this.sons.add(fatherAndSonRelation);
    }
}
