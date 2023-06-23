package com.tourguide.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.user.model.User;
import com.tourguide.user.enums.Role;
import com.tourguide.user.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add-role")
    public ResponseEntity<Void> addRole(@RequestBody User user, Role role) {
        // This method would need to be secured to only allow an admin to access it.
        adminService.addRole(user.getId(), role);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/remove-role")
    public ResponseEntity<Void> removeRole(@RequestBody User user, Role role) {
        // This method would need to be secured to only allow an admin to access it.
        adminService.removeRole(user.getId(), role);
        return ResponseEntity.noContent().build();
    }
}

