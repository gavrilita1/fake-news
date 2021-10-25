package com.example.fakenews.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="TWEET")
public class Tweet {

    @Id
    @Column(name="TWEET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tweetId;

    @Column(name= "ACCOUNT_ID")
    private Integer accountId;

    @Column(name = "CONTENT")
    private String content;

    @Column(name= "LIKES")
    private Integer likes;

    @Column(name= "QOUTE_TWEETS")
    private Integer qouteTweets;

    @Column(name= "RETWEETS")
    private Integer reTweets;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public Tweet() {
    }

    public Tweet(Integer accountId, String content, Integer likes, Integer qouteTweets, Integer reTweets, Date creationDate) {
        this.accountId = accountId;
        this.content = content;
        this.likes = likes;
        this.qouteTweets = qouteTweets;
        this.reTweets = reTweets;
        this.creationDate = creationDate;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getQouteTweets() {
        return qouteTweets;
    }

    public void setQouteTweets(Integer qouteTweets) {
        this.qouteTweets = qouteTweets;
    }

    public Integer getReTweets() {
        return reTweets;
    }

    public void setReTweets(Integer reTweets) {
        this.reTweets = reTweets;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
