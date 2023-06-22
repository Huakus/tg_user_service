package com.tourguide.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tourguide.user.model.Role;
import com.tourguide.user.repository.UserRepository;
import com.tourguide.user.service.AdminService;

public class AdminServiceImpl implements AdminService{

    private final UserRepository userRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addRole(Long userId, Role role) {
        // Here you would add the role to the user's role set and then save the user
        // Remember to handle the case where no user is found with the given id
    }

    @Override
    public void removeRole(Long userId, Role role) {
        // Here you would remove the role from the user's role set and then save the user
        // Remember to handle the case where no user is found with the given id
    }
}
