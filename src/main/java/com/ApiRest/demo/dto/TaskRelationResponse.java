package com.ApiRest.demo.dto;

import java.util.List;

public class TaskRelationResponse {

    private Long taskId;
    private List<PersonWithHabilities> persons;

    // Constructor
    public TaskRelationResponse(Long taskId, List<PersonWithHabilities> persons) {
        this.taskId = taskId;
        this.persons = persons;
    }

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

    public static class PersonWithHabilities {
        private Long personId;
        private List<Long> habilities;

        // Constructor
        public PersonWithHabilities(Long personId, List<Long> habilities) {
            this.personId = personId;
            this.habilities = habilities;
        }

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
