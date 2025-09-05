package com.crowdsolve.crowdsolve_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Authority authority;
}
