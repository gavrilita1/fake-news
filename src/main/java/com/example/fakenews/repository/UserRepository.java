package com.example.fakenews.repository;

import com.example.fakenews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
