package com.crowdsolve.crowdsolve_backend.controller;

import com.crowdsolve.crowdsolve_backend.model.Admin;
import com.crowdsolve.crowdsolve_backend.model.Authority;
import com.crowdsolve.crowdsolve_backend.repository.AdminRepository;
import com.crowdsolve.crowdsolve_backend.repository.AuthorityRepository;
import com.crowdsolve.crowdsolve_backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private AuthorityRepository authorityRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        // 1. Try admin login
        Admin admin = adminRepo.findByUsername(username).orElse(null);
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            String token = jwtUtil.generateToken(username, "ROLE_ADMIN");
            return Map.of("token", token, "role", "ADMIN");
        }

        // 2. Try authority login
        Authority authority = authorityRepo.findByContactEmail(username).orElse(null);
        // using dept_name as login
        if (authority != null && passwordEncoder.matches(password, authority.getPassword())) {
            String token = jwtUtil.generateToken(username, "ROLE_AUTHORITY");
            return Map.of("token", token, "role", "AUTHORITY");
        }

        throw new RuntimeException("Invalid credentials");
    }
}
