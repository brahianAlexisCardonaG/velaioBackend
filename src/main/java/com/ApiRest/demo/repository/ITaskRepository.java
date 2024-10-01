package com.ApiRest.demo.repository;

import com.ApiRest.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository <Task,Long> {

    List<Task> findByStateContaining(String state);
}
