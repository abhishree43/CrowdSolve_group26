package com.crowdsolve.crowdsolve_backend.controller;

import com.crowdsolve.crowdsolve_backend.model.*;
import com.crowdsolve.crowdsolve_backend.repository.CitizenRepository;
import com.crowdsolve.crowdsolve_backend.repository.ComplaintRepository;
import com.crowdsolve.crowdsolve_backend.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepo;

    @Autowired
    private CitizenRepository citizenRepo;

    @Autowired
    private IssueRepository issueRepo;

    // Citizen files a complaint
    @PostMapping("/{citizenId}")
    public Complaint createComplaint(@PathVariable Long citizenId, @RequestBody Complaint complaint) {
        citizen citizen = citizenRepo.findById(citizenId).orElseThrow();
        Issue issue = issueRepo.findById(complaint.getIssue().getIssueId()).orElseThrow();

        complaint.setCitizen(citizen);
        complaint.setIssue(issue);
        complaint.setStatus(ComplaintStatus.PENDING);

        return complaintRepo.save(complaint);
    }

    // Get complaint by ID
    @GetMapping("/{complaintId}")
    public Complaint getComplaint(@PathVariable Long complaintId) {
        return complaintRepo.findById(complaintId).orElseThrow();
    }

    // Get all complaints (for testing / admin view)
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }

    // Get all complaints for a citizen
    @GetMapping("/citizen/{citizenId}")
    public List<Complaint> getComplaintsByCitizen(@PathVariable Long citizenId) {
        citizen citizen = citizenRepo.findById(citizenId).orElseThrow();
        return complaintRepo.findAll()
                .stream()
                .filter(c -> c.getCitizen().equals(citizen))
                .toList();
    }
}
