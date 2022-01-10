package com.example.fakenews.controller;

import com.example.fakenews.entity.Credentials;
import com.example.fakenews.entity.User;
import com.example.fakenews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.JSONObject;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/users")
    public List<User> addUsers(@RequestBody List<User> user) {
        return userService.saveUsers(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable(name = "userId") Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/userName")
    public User getUserByName(@RequestBody String  userName) {
        return userService.getUserByName(userName);
    }

    @GetMapping("/login")
    public Credentials login(@RequestBody Credentials credentials) {
        return userService.login(credentials);
    }

    @PostMapping("/signUp")
    public Credentials signUp(@RequestBody Credentials credentials) {
        return userService.signUp(credentials);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long userId) {
        userService.deleteUser(userId);
    }
}
