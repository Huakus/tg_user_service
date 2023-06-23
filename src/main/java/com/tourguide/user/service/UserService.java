package com.tourguide.user.service;

import java.util.List;

import com.tourguide.user.model.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserByUuid(String uuid);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(String uuid);
    User loadUserByUsername(String username);
}
