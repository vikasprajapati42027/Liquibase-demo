package com.liquibase.controller;

import com.liquibase.model.Person;
import com.liquibase.model.Response;
import com.liquibase.services.serviceimpl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class Controller {

    @Autowired
    private final PersonServiceImpl personService;

    @PostMapping("/create")
    public ResponseEntity<Response> createPerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("person", personService.create(person)))
                        .message("person Created successfully")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .developerMessage("vikas")
                        .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getAllthepeople(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("persons", personService.list(20)))
                        .message("person retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );

    }
}
