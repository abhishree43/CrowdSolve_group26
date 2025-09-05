package com.crowdsolve.crowdsolve_backend.controller;

import com.crowdsolve.crowdsolve_backend.model.citizen;
import com.crowdsolve.crowdsolve_backend.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    // Create a new citizen
    @PostMapping
    public citizen createCitizen(@RequestBody citizen citizen) {
        return citizenRepository.save(citizen);
    }

    // Get all citizens
    @GetMapping
    public List<citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }
}
