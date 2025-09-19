package com.crowdsolve.crowdsolve_backend.repository;

import com.crowdsolve.crowdsolve_backend.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    // search by dept_name (since we use it as username for login)
    Optional<Authority> findByDeptName(String deptName);
    Optional<Authority> findByContactEmail(String contactEmail);
}
