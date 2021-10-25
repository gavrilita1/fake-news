package com.example.fakenews.controller;

import com.example.fakenews.entity.TweetAccount;
import com.example.fakenews.service.TweetAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweetAccount/")
public class TweetAccountController {

    @Autowired
    private TweetAccountService tweetAccountService;

    @PostMapping
    public TweetAccount saveTweetAccount(@RequestBody TweetAccount tweetAccount) {
        return tweetAccountService.saveTweetAccount(tweetAccount);
    }

    @PostMapping("/tweetAccounts")
    public List<TweetAccount> addTweetAccounts(@RequestBody List<TweetAccount> tweetAccount) {
        return tweetAccountService.saveTweetAccounts(tweetAccount);
    }

    @GetMapping
    public List<TweetAccount> getAllTweetAccounts() {
        return tweetAccountService.getAllTweetAccounts();
    }

    @GetMapping("{tweetAccountId}")
    public TweetAccount getTweetAccount(@PathVariable(name = "tweetAccountId") Long tweetAccountId) {
        return tweetAccountService.getTweetAccount(tweetAccountId);
    }

    @PutMapping()
    public TweetAccount updateTweetAccount(@RequestBody TweetAccount tweetAccount) {
        return tweetAccountService.updateTweetAccount(tweetAccount);
    }

    @DeleteMapping("/delete/{tweetAccountId}")
    public void deleteTweetAccount(@PathVariable(name = "tweetAccountId") Long tweetAccountId) {
        tweetAccountService.deleteTweetAccount(tweetAccountId);
    }
}
