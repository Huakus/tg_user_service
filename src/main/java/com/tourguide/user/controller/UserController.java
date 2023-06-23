package com.tourguide.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.user.model.User;
import com.tourguide.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<User> getUserById(@PathVariable String uuid) {
        return ResponseEntity.ok(userService.getUserByUuid(uuid));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<User> updateUser(@PathVariable String uuid, @RequestBody User user) {
        user.setUuid(uuid);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteUser(@PathVariable String uuid) {
        userService.deleteUser(uuid);
        return ResponseEntity.noContent().build();
    }
}
