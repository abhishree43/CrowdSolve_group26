package com.crowdsolve.crowdsolve_backend.controller;


import com.crowdsolve.crowdsolve_backend.model.Complaint;
import com.crowdsolve.crowdsolve_backend.model.User;
import com.crowdsolve.crowdsolve_backend.repository.ComplaintRepository;
import com.crowdsolve.crowdsolve_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/{userId}")
    public Complaint createComplaint(@PathVariable Long userId, @RequestBody Complaint complaint) {
        User user = userRepo.findById(userId).orElseThrow();
        complaint.setUser(user);
        return complaintRepo.save(complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }
}