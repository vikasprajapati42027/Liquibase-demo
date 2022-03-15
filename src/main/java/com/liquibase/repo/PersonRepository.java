package com.liquibase.repo;


import com.liquibase.model.Person;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query("Select name from Person p where p.name LIKE %:personName%")
    String findByName(String personName);



}
