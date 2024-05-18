package com.example.demo.repository;

import com.example.demo.model.UserSpring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSpring, Long> {
    UserSpring findByUsername(String username);
}
