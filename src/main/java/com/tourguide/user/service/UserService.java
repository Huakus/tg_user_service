package com.tourguide.user.service;

import java.util.List;
import java.util.Optional;

import com.tourguide.user.model.User;
import com.tourguide.user.model.Role;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User loadUserByUsername(String username);
    void changePassword(Long id, String newPassword);
    void addRole(Long userId, Role role);
    void removeRole(Long userId, Role role);
    boolean authenticate(String username, String password);
}
