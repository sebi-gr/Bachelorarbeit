package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link User} instances. Provides basic CRUD operations due to the extension of {@link JpaRepository}.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by username.
     *
     * @param username the username of the user to find.
     * @return the user with the specified username or null if no such user exists.
     */
    User findByUsername(String username);
}
