package com.tourguide.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourguide.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
