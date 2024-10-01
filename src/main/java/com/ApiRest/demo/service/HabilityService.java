package com.ApiRest.demo.service;

import com.ApiRest.demo.dto.HabilityResponse;
import com.ApiRest.demo.dto.TaskResponse;
import com.ApiRest.demo.entity.Hability;
import com.ApiRest.demo.entity.Person;
import com.ApiRest.demo.entity.Task;
import com.ApiRest.demo.repository.IHabilityRepository;
import com.ApiRest.demo.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilityService {

    private IHabilityRepository habilityRepository;

    @Autowired
    public HabilityService(IHabilityRepository habilityRepository) {
        this.habilityRepository = habilityRepository;
    }

    public void createdHability(Hability hability){
        habilityRepository.save(hability);
    }

    public void updateHability(Hability hability){
        habilityRepository.save(hability);
    }

    public void deleteHability(Long id){
        habilityRepository.deleteById(id);
    }

    public List<HabilityResponse> getAllHabilities() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Hability> habilities = habilityRepository.findAll(sort);
        return habilities.stream()
                .map(this::mapToHabilityResponse)
                .toList();
    }

    private HabilityResponse mapToHabilityResponse(Hability hability) {
        HabilityResponse response = new HabilityResponse();
        response.setId(hability.getId());
        response.setName(hability.getName());
        return response;
    }

}
