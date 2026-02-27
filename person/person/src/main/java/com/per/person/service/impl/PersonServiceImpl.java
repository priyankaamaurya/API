package com.per.person.service.impl;

import com.per.person.entity.Person;
import com.per.person.exception.PersonException;
import com.per.person.repository.PersonRepository;
import com.per.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        if (personRepository.existsByName(person.getName()))
            throw new PersonException("name is already exist");
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found "));
    }

    @Override
    public Person updatePerson(int id, Person person) {
        Person person1 = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found "));

        return personRepository.save(person);
    }

    @Override
    public void deletePerson(int id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found "));

        personRepository.delete(person);
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }


}
