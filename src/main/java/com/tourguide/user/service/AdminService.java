package com.tourguide.user.service;

import com.tourguide.user.model.Role;

public interface AdminService {
    void addRole(Long userId, Role role);
    void removeRole(Long userId, Role role);
}
