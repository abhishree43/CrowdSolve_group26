package com.crowdsolve.crowdsolve_backend.model;

import com.crowdsolve.crowdsolve_backend.model.Complaint;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

