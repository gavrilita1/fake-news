package com.example.fakenews.controller;

import com.example.fakenews.entity.User;
import com.example.fakenews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class EntityController {

    @Autowired
    private UserService entityService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return entityService.saveUser(user);
    }

    @PostMapping("/users")
    public List<User> addUsers(@RequestBody List<User> user) {
        return entityService.saveUsers(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return entityService.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable(name = "userId") Long userId) {
        return entityService.getUser(userId);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return entityService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long userId) {
        entityService.deleteUser(userId);
    }
}
