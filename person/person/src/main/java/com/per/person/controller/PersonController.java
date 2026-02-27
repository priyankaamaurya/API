package com.per.person.controller;

import com.per.person.entity.Person;
import com.per.person.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @Operation(summary = "create object of person")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "Invalid data")

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.savePerson(person));
    }

    @GetMapping("/all")
    public List<Person> findAllPerson(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Person> findPersonById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updatePerson(id, person));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePerson(@PathVariable int id){
        service.deletePerson(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Person deleted successfully");
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Person>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }
}
