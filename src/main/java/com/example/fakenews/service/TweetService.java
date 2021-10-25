package com.example.fakenews.service;

import com.example.fakenews.entity.Tweet;
import com.example.fakenews.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TweetService implements iTweetService {

    @Autowired
    TweetRepository tweetRepository;

    @Override
    public Tweet saveTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public List<Tweet> saveTweets(List<Tweet> tweets) {
        for (Tweet tweet : tweets) {
            tweetRepository.save(tweet);
        }
        return tweets;
    }

    @Override
    public List<Tweet> getAllTweets() {
        return (List<Tweet>) tweetRepository.findAll();
    }

    @Override
    public Tweet getTweet(Long tweetId) {
        return tweetRepository.findById(tweetId).get();
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        Tweet existingTweet = tweetRepository.findById(tweet.getTweetId()).orElse(null);
        existingTweet.setAccountId(tweet.getAccountId());
        existingTweet.setContent(tweet.getContent());
        existingTweet.setLikes(tweet.getLikes());
        existingTweet.setQouteTweets(tweet.getQouteTweets());
        existingTweet.setReTweets(tweet.getReTweets());
        existingTweet.setCreationDate(tweet.getCreationDate());
        return tweetRepository.save(existingTweet);
    }

    @Override
    public void deleteTweet(Long TweetId) {
        tweetRepository.deleteById(TweetId);
    }
}
