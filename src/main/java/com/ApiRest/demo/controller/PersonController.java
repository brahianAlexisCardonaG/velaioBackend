package com.ApiRest.demo.controller;

import com.ApiRest.demo.dto.PersonResponse;
import com.ApiRest.demo.entity.Person;
import com.ApiRest.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "create", headers = "Accept=application/json")
    public void createPerson(@RequestBody Person person){
        personService.createdTask(person);
    }

    @GetMapping(value = "list", headers = "Accept=application/json")
    public List<PersonResponse> ListPerson() {
        return personService.getAllPersons();
    }

    @PutMapping(value = "update", headers = "Accept=application/json")
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }

    @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

}
