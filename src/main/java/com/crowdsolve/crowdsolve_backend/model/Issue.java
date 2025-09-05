package com.crowdsolve.crowdsolve_backend.model;

import com.crowdsolve.crowdsolve_backend.model.Authority;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    @Enumerated(EnumType.STRING)
    private IssueType issueType;

    @OneToOne
    @JoinColumn(name = "dept_id")
    private Authority authority;
}
