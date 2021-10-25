package com.example.fakenews.service;

import com.example.fakenews.entity.TweetAccount;

import java.util.List;

public interface iTweetAccountService {

    TweetAccount saveTweetAccount(TweetAccount tweetAccount);
    TweetAccount updateTweetAccount(TweetAccount tweetAccount);
    List<TweetAccount> getAllTweetAccounts();
    TweetAccount getTweetAccount(Long accountId);
    void deleteTweetAccount(Long accountId);
}
