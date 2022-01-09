package com.example.fakenews.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="CHECKS")
public class Check {

	@Id
    @Column(name="CHECK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkId;

    @Column(name= "TWEET_ID")
    private int tweetId;

    @Column(name= "VERDICT")
    private int verdict;
    
    @Column(name= "REASON")
    private String reason;


	public Check(int tweetId, int verdict, String reason) {
		this.tweetId = tweetId;
		this.verdict = verdict;
		this.reason = reason;
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

	public int getVerdict() {
		return verdict;
	}

	public void setVerdict(int verdict) {
		this.verdict = verdict;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}