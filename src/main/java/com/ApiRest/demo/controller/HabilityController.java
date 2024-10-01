package com.ApiRest.demo.controller;

import com.ApiRest.demo.dto.HabilityResponse;
import com.ApiRest.demo.entity.Hability;
import com.ApiRest.demo.service.HabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hability")
public class HabilityController {

    private HabilityService habilityService;

    @Autowired
    public HabilityController(HabilityService habilityService) {
        this.habilityService = habilityService;
    }

    @PostMapping(value = "create", headers = "Accept=application/json")
    public void createHability(@RequestBody Hability hability){
        habilityService.createdHability(hability);
    }

    @GetMapping(value = "list", headers = "Accept=application/json")
    public List<HabilityResponse> ListHability() {
        return habilityService.getAllHabilities();
    }

    @PutMapping(value = "update", headers = "Accept=application/json")
    public void updateHability(@RequestBody Hability hability){
        habilityService.updateHability(hability);
    }

    @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
    public void deleteHability(@PathVariable Long id){
        habilityService.deleteHability(id);
    }

}
