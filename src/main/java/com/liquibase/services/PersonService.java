package com.liquibase.services;

import com.liquibase.model.Person;

import java.util.Collection;

public interface PersonService {
    Person create(Person person);
    Collection<Person> list(int limit);
}
