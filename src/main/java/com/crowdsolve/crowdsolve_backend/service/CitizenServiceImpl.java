package com.crowdsolve.crowdsolve_backend.service;

import com.crowdsolve.crowdsolve_backend.model.citizen;
import com.crowdsolve.crowdsolve_backend.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public citizen registerCitizen(String name, String phoneNumber, String location) {
        citizen citizen = new citizen();
        citizen.setName(name);
        citizen.setPhoneNumber(phoneNumber);
        citizen.setLocation(location);
        return citizenRepository.save(citizen);
    }

    @Override
    public citizen findByPhoneNumber(String phoneNumber) {
        return citizenRepository.findByPhoneNumber(phoneNumber);
    }
}
