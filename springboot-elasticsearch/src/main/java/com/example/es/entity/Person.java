package com.example.es.entity;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//import javax.persistence.Id;

@Document(indexName = "person",type = "_doc")
public class Person  {

    //@Id
    private String id;

    @Field(type = FieldType.Text,searchAnalyzer="ik_smart",analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Keyword)
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
