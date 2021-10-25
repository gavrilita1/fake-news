package com.example.fakenews.service;

import com.example.fakenews.entity.Tweet;

import java.util.List;

public interface iTweetService {

    Tweet saveTweet(Tweet tweet);
    Tweet updateTweet(Tweet tweet);
    List<Tweet> getAllTweets();
    Tweet getTweet(Long tweetId);
    void deleteTweet(Long tweetId);
}
