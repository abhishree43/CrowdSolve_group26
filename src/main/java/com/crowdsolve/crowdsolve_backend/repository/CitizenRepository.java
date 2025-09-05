package com.crowdsolve.crowdsolve_backend.repository;

import com.crowdsolve.crowdsolve_backend.model.citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<citizen, Long> {
    citizen findByPhoneNumber(String phoneNumber);
}
