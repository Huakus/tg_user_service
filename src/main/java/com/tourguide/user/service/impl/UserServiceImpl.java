package com.tourguide.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.user.model.User;
import com.tourguide.user.model.Role;
import com.tourguide.user.repository.UserRepository;
import com.tourguide.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        // Here you would usually encode the password, for example with BCryptPasswordEncoder
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // Here you would usually check if the user exists first
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void changePassword(Long id, String newPassword) {
        // Here you would usually encode the new password and then update it
        // Remember to handle the case where no user is found with the given id
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

    @Override
    public boolean authenticate(String username, String password) {
        // Here you would typically use Spring Security's authentication manager
        return false;
    }
}
