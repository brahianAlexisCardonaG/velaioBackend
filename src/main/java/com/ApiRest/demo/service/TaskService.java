package com.ApiRest.demo.service;

import com.ApiRest.demo.dto.*;
import com.ApiRest.demo.entity.Hability;
import com.ApiRest.demo.entity.Person;
import com.ApiRest.demo.entity.Task;
import com.ApiRest.demo.repository.IHabilityRepository;
import com.ApiRest.demo.repository.IPersonRepository;
import com.ApiRest.demo.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private ITaskRepository taskRepository;
    private IPersonRepository personRepository;
    private IHabilityRepository habilityRepository;

    @Autowired
    public TaskService(ITaskRepository taskRepository, IPersonRepository personRepository, IHabilityRepository habilityRepository) {
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
        this.habilityRepository = habilityRepository;
    }

    public void createdTask(Task task){
        task.setState("PENDIENTES");
        taskRepository.save(task);
    }

    public void updateTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public List<TaskResponse> getAllTasks() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Task> tasks = taskRepository.findAll(sort);
        return tasks.stream()
                .map(this::mapToTaskResponse)
                .toList(); // Java 16+; use collect(Collectors.toList()) for earlier versions
    }

    public List<TaskResponse> getTaskByState(String state) {
        List<Task> tasks = taskRepository.findByStateContaining(state);
        return tasks.stream()
                .map(this::mapToTaskResponse)
                .toList();
    }

    public TaskRelateResponse getTasksRelate(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(this::convertToDto).orElse(null);
    }

    @Transactional
    public void changeState(StatusChangeRequest statusChangeRequest) {
        Optional<Task> task = taskRepository.findById(statusChangeRequest.getId());
        if(task.isPresent()) {
            Task getTask = task.get();
            getTask.setState("COMPLETADAS");
            taskRepository.save(getTask);
        }
    }

    @Transactional
    public void saveTaskWithRelations(TaskRelationRequest request) {
        for (TaskRelationRequest.TaskWithPersons taskWithPersons : request.getTasks()) {
            Optional<Task> taskOpt = taskRepository.findById(taskWithPersons.getTaskId());
            if (taskOpt.isPresent()) {
                Task task = taskOpt.get();
                for (TaskRelationRequest.PersonWithHabilities personWithHabilities : taskWithPersons.getPersons()) {
                    Optional<Person> personOpt = personRepository.findById(personWithHabilities.getPersonId());

                    if (personOpt.isPresent()) {
                        Person person = personOpt.get();
                        person.getTasks().add(task);
                        for (Long habilityId : personWithHabilities.getHabilities()) {
                            Optional<Hability> habilityOpt = habilityRepository.findById(habilityId);

                            if (habilityOpt.isPresent()) {
                                Hability hability = habilityOpt.get();
                                person.getHabilities().add(hability);
                            }
                        }
                        personRepository.save(person);
                    }
                }
            }
        }

    }

    private TaskResponse mapToTaskResponse(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setName(task.getName());
        response.setDate(task.getDate());
        response.setState(task.getState());
        return response;
    }

    private TaskRelateResponse convertToDto(Task task) {
        TaskRelateResponse taskDto = new TaskRelateResponse();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDate(task.getDate());
        taskDto.setState(task.getState());
        taskDto.setPersons(task.getPersons().stream()
                .map(person -> {
                    PersonRelateResponse personDto = new PersonRelateResponse();
                    personDto.setId(person.getId());
                    personDto.setName(person.getName());
                    personDto.setLastName(person.getLastName());
                    personDto.setAge(person.getAge());
                    personDto.setHabilities(person.getHabilities().stream()
                            .map(hability -> new HabilityResponse(hability.getId(), hability.getName()))
                            .collect(Collectors.toSet()));
                    return personDto;
                })
                .collect(Collectors.toSet()));

        return taskDto;
    }
}
