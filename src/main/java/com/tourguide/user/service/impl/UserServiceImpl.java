package com.tourguide.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tourguide.user.model.User;
import com.tourguide.user.repository.UserRepository;
import com.tourguide.user.service.UserService;
import com.tourguide.user.utils.UserValidator;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserValidator userValidator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserValidator userValidator) {  
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userValidator = userValidator;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUuid(String uuid) {
        return userRepository.findByUuid(uuid);
    }

    @Override
    public User createUser(User user) {
        userValidator.forUser(user)
            .checkUsernameIsNotEmpty()    
            .checkUsernameIsUnique()
            .checkEmailIsNotEmpty()
            .checkEmailIsUnique()
            .checkPasswordIsValid();
            
        // Here you encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save and return the user
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // Here you would usually check if the user exists first
        
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String uuid) {
        userRepository.deleteByUuid(uuid);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
