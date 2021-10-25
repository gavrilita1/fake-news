package com.example.fakenews.controller;

import com.example.fakenews.entity.User;
import com.example.fakenews.entity.Check;
import com.example.fakenews.service.CheckService;
import com.example.fakenews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/user/", "/check"})
public class EntityController {

    @Autowired
    private UserService entityService;
    // banui ca asa ar trebui numit: checkService, eventual entityService de sus fiind renumit in userService, idk
    private CheckService checkService;

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
    
    // toate metodele pentru check sunt aici, am asumat ca toate pentru user se regasesc si pentru check
    @PostMapping
    public Check saveCheck(@RequestBody Check check) {
        return checkService.saveCheck(check);
    }

    @PostMapping("/checks")
    public List<Check> addChecks(@RequestBody List<Check> check) {
        return checkService.saveChecks(check);
    }

    @GetMapping
    public List<Check> getAllChecks() {
        return checkService.getAllChecks();
    }

    @GetMapping("{checkId}")
    public Check getCheck(@PathVariable(name = "checkId") Long checkId) {
        return checkService.getCheck(checkId);
    }

    @PutMapping()
    public Check updateCheck(@RequestBody Check check) {
        return checkService.updateCheck(check);
    }

    @DeleteMapping("/delete/{checkId}")
    public void deleteCheck(@PathVariable(name = "checkId") Long checkId) {
        checkService.deleteCheck(checkId);
    }
}
