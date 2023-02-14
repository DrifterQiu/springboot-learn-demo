package com.example.es.repository;

import com.example.es.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEsRepository extends ElasticsearchRepository<Person, String> {
}
