package com.example.fakenews.controller;

import com.example.fakenews.entity.Tweet;
import com.example.fakenews.service.AlgorithmService;
import com.example.fakenews.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;


import java.util.List;

@RestController
@RequestMapping("/tweet/")
public class TweetController {

    @Autowired
    private TweetService tweetService;



    @GetMapping(value = "/testAPI/{tweetId}")
    public AlgorithmService tweetUser(@PathVariable(name = "tweetId") Long tweetId) throws TwitterException {
            return tweetService.tweetUser(tweetId);
    }

    @PostMapping
    public Tweet saveTweet(@RequestBody Tweet tweet) {
        return tweetService.saveTweet(tweet);
    }

    @PostMapping("/tweets")
    public List<Tweet> addTweets(@RequestBody List<Tweet> tweet) {
        return tweetService.saveTweets(tweet);
    }

    @GetMapping
    public List<Tweet> getAllTweets() {
        return tweetService.getAllTweets();
    }

    @GetMapping("{tweetId}")
    public Tweet getTweet(@PathVariable(name = "tweetId") Long tweetId) {
        return tweetService.getTweet(tweetId);
    }

    @PutMapping()
    public Tweet updateTweet(@RequestBody Tweet tweet) {
        return tweetService.updateTweet(tweet);
    }

    @DeleteMapping("/delete/{tweetId}")
    public void deleteTweet(@PathVariable(name = "tweetId") Long tweetId) {
        tweetService.deleteTweet(tweetId);
    }

}
