package com.crowdsolve.crowdsolve_backend.service;

import com.crowdsolve.crowdsolve_backend.model.citizen;

public interface CitizenService {
    citizen registerCitizen(String name, String phoneNumber, String location);
    citizen findByPhoneNumber(String phoneNumber);
}
