package com.per.person.repository;

import com.per.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select p from Person p where p.name=?1")
    List<Person> findByName(String name);

    boolean existsByName(String name);
}
