package com.tourguide.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.user.enums.Role;
import com.tourguide.user.model.User;
import com.tourguide.user.repository.UserRepository;
import com.tourguide.user.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addRole(Long userId, Role role) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("No user found with id: " + userId));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public void removeRole(Long userId, Role role) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("No user found with id: " + userId));
        user.getRoles().remove(role);
        userRepository.save(user);
    }
}

