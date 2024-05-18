package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for User entity operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
