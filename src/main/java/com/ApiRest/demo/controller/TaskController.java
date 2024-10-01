package com.ApiRest.demo.controller;

import com.ApiRest.demo.dto.StatusChangeRequest;
import com.ApiRest.demo.dto.TaskRelateResponse;
import com.ApiRest.demo.dto.TaskRelationRequest;
import com.ApiRest.demo.dto.TaskResponse;
import com.ApiRest.demo.entity.Task;
import com.ApiRest.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "create", headers = "Accept=application/json")
    public void createTask(@RequestBody Task task){
        taskService.createdTask(task);
    }

    @GetMapping(value = "list", headers = "Accept=application/json")
    public List<TaskResponse> ListTask(@RequestParam(value = "state", required = false) String state) {
        if (!state.isEmpty()){
            return taskService.getTaskByState(state);
        }else {
            return taskService.getAllTasks();
        }
    }

    @PutMapping(value = "update-status", headers = "Accept=application/json")
    public void changeStatechangeState(@RequestBody StatusChangeRequest data){
        taskService.changeState(data);
    }

    @PutMapping(value = "update", headers = "Accept=application/json")
    public void updateTask(@RequestBody Task task){
        taskService.updateTask(task);
    }

    @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PostMapping("/save-relations")
    public ResponseEntity<Void> saveTaskWithRelations(@RequestBody TaskRelationRequest request) {
        taskService.saveTaskWithRelations(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "list-relations", headers = "Accept=application/json")
    public TaskRelateResponse getTasksRelate(@RequestParam(value = "id", required = false) Long id) {
        return taskService.getTasksRelate(id);
    }

}
