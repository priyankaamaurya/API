package com.per.person.controller;

import com.per.person.entity.Person;
import com.per.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    PersonService service;

    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        return service.savePerson(person);
    }

    @GetMapping("/all")
    public List<Person> findAllPerson(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person){
        return service.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id){
        service.deletePerson(id);
        return "Person deleted successfully";
    }
}
