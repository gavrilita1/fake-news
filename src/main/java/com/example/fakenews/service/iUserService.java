package com.example.fakenews.service;

import com.example.fakenews.entity.User;

import java.util.List;

public interface iUserService {

    User saveUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
    User getUser(Long userId);
    void deleteUser(Long userId);
}
