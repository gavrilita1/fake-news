package com.example.fakenews.controller;

import com.example.fakenews.entity.Check;
import com.example.fakenews.service.AlgorithmService;
import com.example.fakenews.service.CheckService;
import com.example.fakenews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/check/")
public class CheckController {

    @Autowired
    private CheckService checkService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/tweetCheck/{tweetId}/{userId}")
    public AlgorithmService tweetCheck(@PathVariable(name = "tweetId") Long tweetId, @PathVariable(name = "userId") Long userId, @RequestBody String url) throws TwitterException {
        return checkService.tweetCheck(tweetId, userId, url);
    }

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

    @PostMapping("/history/{userId}")
    public List<Check> getHistory(@PathVariable(name="userId") Long userId) {
        return checkService.checkHistory(userId);
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
