package com.crowdsolve.crowdsolve_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private citizen citizen;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;

    private String photo;  // store path or URL
    private String complaintDetails;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus status = ComplaintStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    // ---------- Constructors ----------
    public Complaint() {
    }

    public Complaint(Long complaintId, citizen citizen, Issue issue,
                     String photo, String complaintDetails,
                     ComplaintStatus status,
                     LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.complaintId = complaintId;
        this.citizen = citizen;
        this.issue = issue;
        this.photo = photo;
        this.complaintDetails = complaintDetails;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // ---------- Getters & Setters ----------

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(citizen citizen) {
        this.citizen = citizen;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
