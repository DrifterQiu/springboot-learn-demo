package com.example.es.controller;

import com.example.es.entity.Person;
import com.example.es.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/es")
public class EsTestController {

    private final static Logger logger = LoggerFactory.getLogger(EsTestController.class);

    @Autowired
    PersonService personService;

    /**
     * 新增
     * @param person
     * @return
     */
    @PostMapping("/person")
    public String save(@RequestBody Person person) {
        String documentId = personService.createUser(person);
        logger.info(documentId);
        return documentId;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/person/{id}")
    public Person findById(@PathVariable("id")  String id) {
        Person person = personService.findPersonById(id);
        return person;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public void deleteUser(){
        personService.deleteIndex();
    }

    /**
     * 高亮显示
     * @param name
     */
    @GetMapping("/searchHigh/{name}")
    public void searchHigh(@PathVariable("name") String name) {
        List<Person> personList = personService.searchHigh(name);
        personList.stream().forEach(person -> System.out.println(person));
    }


    /**
     * 返回分词结果
     * @param name
     */
    @GetMapping("/getParticipesResult/{name}")
    public void getParticipesResult(@PathVariable("name") String name) {
        List<String> participesResultList = personService.getParticipesResult(name);
        participesResultList.stream().forEach(String -> System.out.println(String));
    }
}
