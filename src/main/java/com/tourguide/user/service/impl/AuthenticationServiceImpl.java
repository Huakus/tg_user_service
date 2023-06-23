package com.tourguide.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tourguide.user.model.User;
import com.tourguide.user.repository.UserRepository;
import com.tourguide.user.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void changePassword(Long id, String newPassword) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No user found with id: " + id));
        
        // encode the new password
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public boolean authenticate(String username, String password) {
        try {
            // Create an authentication token using the provided username and password
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            
            // Attempt to authenticate the user
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            
            // If successful, return true
            return authentication.isAuthenticated();
        } catch (AuthenticationException e) {
            // If any exception occurs during authentication, return false
            return false;
        }
    }
}
