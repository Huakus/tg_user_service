package com.tourguide.user.service;

public interface AuthenticationService {
    boolean authenticate(String username, String password);
    void changePassword(Long id, String newPassword);
}
