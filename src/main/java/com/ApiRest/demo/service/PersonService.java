package com.ApiRest.demo.service;

import com.ApiRest.demo.dto.PersonResponse;
import com.ApiRest.demo.entity.Person;
import com.ApiRest.demo.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private IPersonRepository personRepository;

    @Autowired
    public PersonService(IPersonRepository IPersonRepository) {
        this.personRepository = IPersonRepository;
    }

    public void createdTask(Person person){
        personRepository.save(person);
    }

    public void updatePerson(Person person){
        personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public List<PersonResponse> getAllPersons() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Person> person = personRepository.findAll(sort);
        return person.stream()
                .map(this::mapToPersonResponse)
                .toList();
    }

    private PersonResponse mapToPersonResponse(Person person) {
        PersonResponse response = new PersonResponse();
        response.setId(person.getId());
        response.setName(person.getName());
        response.setLastName(person.getLastName());
        response.setAge(person.getAge());
        return response;
    }

}
