package com.per.person.service;

import com.per.person.entity.Person;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);
    
    List<Person> findAll();

    Person findById(int id);

    Person updatePerson(int id, Person person);

    void deletePerson(int id);

    List<Person> findByName(String name);
}
