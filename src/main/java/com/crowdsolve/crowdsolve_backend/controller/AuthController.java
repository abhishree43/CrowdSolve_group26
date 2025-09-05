package com.crowdsolve.crowdsolve_backend.controller;

import com.crowdsolve.crowdsolve_backend.model.citizen;
import com.crowdsolve.crowdsolve_backend.service.CitizenService;
import com.crowdsolve.crowdsolve_backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Signup API
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {
        citizen citizen = citizenService.registerCitizen(
                body.get("name"),
                body.get("phoneNumber"),
                body.get("location")
        );

        Map<String, String> response = new HashMap<>();
        response.put("message", "Signup successful");
        response.put("citizenId", citizen.getCitizenId().toString());

        return ResponseEntity.ok(response);
    }

    /**
     * Login API
     * (using phoneNumber as identifier, no password check)
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        citizen citizen = citizenService.findByPhoneNumber(body.get("phoneNumber"));
        if (citizen == null) {
            return ResponseEntity.status(404).body("Citizen not found");
        }

        // Generate token with citizenId
        String token = jwtUtil.generateToken(citizen.getCitizenId().toString(), "CITIZEN");

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("citizenId", citizen.getCitizenId());
        response.put("name", citizen.getName());
        response.put("role", "CITIZEN");

        return ResponseEntity.ok(response);
    }
}
