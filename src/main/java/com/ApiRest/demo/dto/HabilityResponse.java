package com.ApiRest.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class HabilityResponse {
    private Long id;
    private String name;

    public HabilityResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public HabilityResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
