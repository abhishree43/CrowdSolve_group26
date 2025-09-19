package com.crowdsolve.crowdsolve_backend.controller;

import com.crowdsolve.crowdsolve_backend.model.*;
import com.crowdsolve.crowdsolve_backend.repository.AdminRepository;
import com.crowdsolve.crowdsolve_backend.repository.ComplaintRepository;
import com.crowdsolve.crowdsolve_backend.repository.AdminActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ComplaintRepository complaintRepo;

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private AdminActionRepository actionRepo;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to the Admin Dashboard!";
    }


    // Approve complaint
    @PutMapping("/complaints/{complaintId}/approve/{adminId}")
    public Complaint approveComplaint(@PathVariable Long complaintId, @PathVariable Long adminId) {
        Complaint complaint = complaintRepo.findById(complaintId).orElseThrow();
        Admin admin = adminRepo.findById(adminId).orElseThrow();

        complaint.setStatus(ComplaintStatus.ACCEPTED);

        AdminAction action = new AdminAction();
        action.setComplaint(complaint);
        action.setAdmin(admin);
        action.setActionType(ActionType.ACCEPTED);
        actionRepo.save(action);

        return complaintRepo.save(complaint);
    }

    // Reject complaint
    @PutMapping("/complaints/{complaintId}/reject/{adminId}")
    public Complaint rejectComplaint(@PathVariable Long complaintId,
                                     @PathVariable Long adminId,
                                     @RequestBody String reason) {
        Complaint complaint = complaintRepo.findById(complaintId).orElseThrow();
        Admin admin = adminRepo.findById(adminId).orElseThrow();

        complaint.setStatus(ComplaintStatus.DECLINED);

        AdminAction action = new AdminAction();
        action.setComplaint(complaint);
        action.setAdmin(admin);
        action.setActionType(ActionType.DECLINED);
        action.setReason(reason);
        actionRepo.save(action);

        return complaintRepo.save(complaint);
    }
}
