package com.crowdsolve.crowdsolve_backend.repository;


import com.crowdsolve.crowdsolve_backend.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {}