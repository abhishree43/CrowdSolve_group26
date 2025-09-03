package com.crowdsolve.crowdsolve_backend.repository;


import com.crowdsolve.crowdsolve_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
