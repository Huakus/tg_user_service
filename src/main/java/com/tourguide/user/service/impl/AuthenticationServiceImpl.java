package com.tourguide.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tourguide.user.repository.UserRepository;
import com.tourguide.user.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void changePassword(Long id, String newPassword) {
        // Here you would usually encode the new password and then update it
        // Remember to handle the case where no user is found with the given id
    }

    @Override
    public boolean authenticate(String username, String password) {
        // Here you would typically use Spring Security's authentication manager
        return false;
    }
}
