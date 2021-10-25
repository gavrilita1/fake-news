package com.example.fakenews.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="CHECK_TABLE")
public class Check {

    @Id
    @Column(name="CHECK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkId;

    @Column(name = "CHECK_DATE")
    private Date checkDate;

    @Column(name = "CHECK_URL")
    private String checkUrl;

    @Column(name= "TWEET_ID")
    private int tweetId;

    @Column(name= "VERDICT")
    private int verdict;
    
    @Column(name= "REASON")
    private String reason;
    
    public Check() {
    }

    public Check(long checkId, Date checkDate, String checkUrl, int tweetId, int verdict, String reason) {
        this.checkId = checkId;
        this.checkDate = checkDate;
        this.checkUrl = checkUrl;
        this.tweetId = tweetId;
        this.verdict = verdict;
        this.reason = reason;
    }

	public long getCheckId() {
		return checkId;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckUrl() {
		return checkUrl;
	}

	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
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