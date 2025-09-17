package com.crowdsolve.crowdsolve_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncodeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Example: http://localhost:8080/encode?raw=password123
    @GetMapping("/encode")
    public String encode(@RequestParam String raw) {
        return passwordEncoder.encode(raw);
    }
}
