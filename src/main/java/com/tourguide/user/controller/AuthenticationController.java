package com.tourguide.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tourguide.user.dto.ChangePasswordDto;
import com.tourguide.user.dto.LoginDto;
import com.tourguide.user.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginDto loginDto) {
        boolean isAuthenticated = authenticationService.authenticate(loginDto.getUsername(), loginDto.getPassword());
        if (isAuthenticated) {
            // Here you would generate and return a JWT or similar authentication token
            return ResponseEntity.ok("Logged in successfully");
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        // This method should be secured to only allow the authenticated user 
        // or an admin to access it.
        boolean isAuthenticated = authenticationService.authenticate(changePasswordDto.getUsername(), changePasswordDto.getOldPassword());
        if (isAuthenticated) {
            authenticationService.changePassword(changePasswordDto.getId(), changePasswordDto.getNewPassword());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
