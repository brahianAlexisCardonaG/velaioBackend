package com.ApiRest.demo.repository;

import com.ApiRest.demo.entity.Person;
import com.ApiRest.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository <Person,Long> {
}
