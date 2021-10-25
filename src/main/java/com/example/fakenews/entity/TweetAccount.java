package com.example.fakenews.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="TWEET_ACCOUNT")
public class TweetAccount {

    @Id
    @Column(name="ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;


    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name= "FOLLOWERS")
    private Integer followers;

    @Column(name = "JOINED_DATE")
    private Date joinedDate;

    @Column(name= "TWEETS")
    private Integer[] tweetsIds = new Integer[0];

    public TweetAccount() {
    }

    public TweetAccount(String accountName, Integer followers, Date joinedDate, Integer[] tweetsIds) {
        this.accountName = accountName;
        this.followers = followers;
        this.joinedDate = joinedDate;
        this.tweetsIds = tweetsIds;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Integer[] getTweetsIds() {
        return tweetsIds;
    }

    public void setTweetsIds(Integer[] tweetsIds) {
        this.tweetsIds = tweetsIds;
    }
}
