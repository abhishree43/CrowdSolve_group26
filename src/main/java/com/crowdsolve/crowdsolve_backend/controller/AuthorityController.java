package com.crowdsolve.crowdsolve_backend.controller;

import com.crowdsolve.crowdsolve_backend.model.Complaint;
import com.crowdsolve.crowdsolve_backend.model.ComplaintStatus;
import com.crowdsolve.crowdsolve_backend.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    private ComplaintRepository complaintRepo;
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to the Authority Dashboard!";
    }

    // Update complaint status (IN_PROGRESS, RESOLVED)
    @PutMapping("/complaints/{complaintId}/status")
    public Complaint updateComplaintStatus(@PathVariable Long complaintId, @RequestBody ComplaintStatus status) {
        Complaint complaint = complaintRepo.findById(complaintId).orElseThrow();
        complaint.setStatus(status);
        complaint.setUpdatedAt(LocalDateTime.now());
        return complaintRepo.save(complaint);
    }
}
