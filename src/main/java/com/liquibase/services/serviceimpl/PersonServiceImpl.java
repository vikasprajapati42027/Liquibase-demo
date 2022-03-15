package com.liquibase.services.serviceimpl;

import com.liquibase.model.Person;
import com.liquibase.repo.PersonRepository;
import com.liquibase.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Collection<Person> list(int limit) {
        return personRepository.findAll(PageRequest.of(0, limit)).toList();
    }
}
