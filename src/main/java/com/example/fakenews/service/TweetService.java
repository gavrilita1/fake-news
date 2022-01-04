package com.example.fakenews.service;

import com.example.fakenews.entity.Tweet;
import com.example.fakenews.repository.TweetRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


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

    public void tweetUser() throws TwitterException {
        final Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
        AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);
        twitter.setOAuthAccessToken(accessToken);


        String tweetID = "1478232471942672385";


        Status status = twitter.showStatus(Long.parseLong(tweetID));
        if (status == null) {
        } else {
            System.out.println("@" + status.getUser().getScreenName()
                    + " - " + status.getText());
        }
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
