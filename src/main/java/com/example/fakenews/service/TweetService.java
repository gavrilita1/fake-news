package com.example.fakenews.service;

import com.example.fakenews.entity.Tweet;
import com.example.fakenews.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import twitter4j.*;
import twitter4j.api.UsersResources;
import twitter4j.auth.AccessToken;


@Service
public class TweetService implements iTweetService {

    @Value("${api_key}")
    private String api_key;
    @Value("${api_key_secret}")
    private String api_key_secret;
    @Value("${bearer_token}")
    private String bearer_token;
    @Value("${consumerKeyStr}")
    private String consumerKeyStr;
    @Value("${consumerSecretStr}")
    private String consumerSecretStr;
    @Value("${accessTokenStr}")
    private String accessTokenStr;
    @Value("${accessTokenSecretStr}")
    private String accessTokenSecretStr;

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    AlgorithmService algorithmService;

    public AlgorithmService tweetUser(Long tweetId) throws TwitterException {

        final Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
        AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);
        twitter.setOAuthAccessToken(accessToken);

        long tweetID=tweetId;

        Status status = twitter.showStatus(tweetID);
        UsersResources user = twitter.users();
        AlgorithmService run = algorithmService.algorithmRun(status, user);

        return run;
    }

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
