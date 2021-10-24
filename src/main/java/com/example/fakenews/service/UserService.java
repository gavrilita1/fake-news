package com.example.fakenews.service;

import com.example.fakenews.entity.User;
import com.example.fakenews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService implements iUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        for (User user : users) {
            userRepository.save(user);
        }
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setUserPassword(user.getUserPassword());
        existingUser.setCheckIds(user.getCheckIds());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
