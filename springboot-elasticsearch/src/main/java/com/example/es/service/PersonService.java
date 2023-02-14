package com.example.es.service;

import com.example.es.entity.Person;

import java.util.List;

public interface PersonService {

    String createUser(Person person);

    Person findPersonById(String id);

    void deleteIndex();

    List<Person> searchHigh(String query);

    List<String> getParticipesResult(String text);

}
