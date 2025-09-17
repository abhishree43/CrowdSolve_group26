package com.crowdsolve.crowdsolve_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_action")
public class AdminAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actionId;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    private String reason;
    private LocalDateTime actionDate = LocalDateTime.now();

    // ---------- Constructors ----------
    public AdminAction() {
    }

    public AdminAction(Long actionId, Complaint complaint, Admin admin,
                       ActionType actionType, String reason, LocalDateTime actionDate) {
        this.actionId = actionId;
        this.complaint = complaint;
        this.admin = admin;
        this.actionType = actionType;
        this.reason = reason;
        this.actionDate = actionDate;
    }

    // ---------- Getters & Setters ----------

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}
