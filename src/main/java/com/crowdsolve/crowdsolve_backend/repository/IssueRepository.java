package com.crowdsolve.crowdsolve_backend.repository;

import com.crowdsolve.crowdsolve_backend.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {}
