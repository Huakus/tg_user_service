package com.tourguide.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.user.model.User;
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
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        // Here you would typically return a JWT or similar authentication token,
        // not the user object itself
        boolean isAuthenticated = authenticationService.authenticate(user.getUsername(), user.getPassword());
        if (isAuthenticated) {
            // return token
            return ResponseEntity.ok(new User());
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody User user, String newPassword) {
        // This method would need to be secured to only allow the authenticated user 
        // or an admin to access it. You would also typically require the old password 
        // to be submitted along with the new one.
        authenticationService.changePassword(user.getId(), newPassword);
        return ResponseEntity.noContent().build();
    }
}
