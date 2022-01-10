package com.example.fakenews.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "CHECKS")
@NamedQueries({@NamedQuery(name = "Check.findByUserId", query = "SELECT check FROM Check check WHERE check.userId = ?1")})
public class Check {

    @Id
    @Column(name = "CHECK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkId;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "TWEET_ID")
    private int tweetId;

    @Column(name = "Score")
    private int score;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "URL")
    private String url;

    public Check() {
    }

    public Check(long userId, int tweetId, int score, String reason, String url) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.score = score;
        this.reason = reason;
        this.url = url;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCheckId() {
        return checkId;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int verdict) {
        this.score = verdict;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}