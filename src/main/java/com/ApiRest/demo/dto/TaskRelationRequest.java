package com.ApiRest.demo.dto;

import java.util.List;

public class TaskRelationRequest {

    private List<TaskWithPersons> tasks;

    // Getters y Setters
    public List<TaskWithPersons> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskWithPersons> tasks) {
        this.tasks = tasks;
    }

    public static class TaskWithPersons {
        private Long taskId;
        private List<PersonWithHabilities> persons;

        // Getters y Setters
        public Long getTaskId() {
            return taskId;
        }

        public void setTaskId(Long taskId) {
            this.taskId = taskId;
        }

        public List<PersonWithHabilities> getPersons() {
            return persons;
        }

        public void setPersons(List<PersonWithHabilities> persons) {
            this.persons = persons;
        }
    }

    public static class PersonWithHabilities {
        private Long personId;
        private List<Long> habilities;

        // Getters y Setters
        public Long getPersonId() {
            return personId;
        }

        public void setPersonId(Long personId) {
            this.personId = personId;
        }

        public List<Long> getHabilities() {
            return habilities;
        }

        public void setHabilities(List<Long> habilities) {
            this.habilities = habilities;
        }
    }
}

