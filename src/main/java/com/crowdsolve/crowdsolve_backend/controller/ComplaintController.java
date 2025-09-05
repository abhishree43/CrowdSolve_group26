package com.crowdsolve.crowdsolve_backend.controller;

import com.crowdsolve.crowdsolve_backend.model.citizen;
import com.crowdsolve.crowdsolve_backend.model.Complaint;
import com.crowdsolve.crowdsolve_backend.repository.CitizenRepository;
import com.crowdsolve.crowdsolve_backend.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepo;

    @Autowired
    private CitizenRepository userRepo;

    // Create a complaint for a specific citizen
    @PostMapping("/{citizenId}")
    public Complaint createComplaint(@PathVariable Long citizenId, @RequestBody Complaint complaint) {
        citizen citizen = citizenRepo.findById(citizenId).orElseThrow();
        complaint.setCitizen(citizen);   // link complaint to citizen
        return complaintRepo.save(complaint);
    }

    // Get all complaints
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }
}
