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


    @PostMapping("/person")
    public String save(@RequestBody Person person) {
        String documentId = personService.createUser(person);
        logger.info(documentId);
        return documentId;
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable("id")  String id) {
        Person person = personService.findPersonById(id);
        return person;
    }

    @DeleteMapping("/delete")
    public void deleteUser(){
        personService.deleteIndex();
    }

    @GetMapping("/searchHigh/{name}")
    public void searchHigh(@PathVariable("name") String name) {
        List<Person> personList = personService.searchHigh(name);
        personList.stream().forEach(person -> System.out.println(person));
    }


    @GetMapping("/getParticipesResult/{name}")
    public void getParticipesResult(@PathVariable("name") String name) {
        List<String> participesResultList = personService.getParticipesResult(name);
        participesResultList.stream().forEach(String -> System.out.println(String));
    }
}
