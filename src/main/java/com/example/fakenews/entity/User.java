package com.example.fakenews.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name= "USER_CHECK_HISTORY")
    private Integer[] checkIds = new Integer[0];

    public User() {
    }

    public User(long userId, String userName, String userPassword, Integer[] checkIds) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.checkIds = checkIds;
    }

    // getUserId() nu era definit
    public long getUserId() {
    	return this.userId;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer[] getCheckIds() {
        return checkIds;
    }

    public void setCheckIds(Integer[] checkIds) {
        this.checkIds = checkIds;
    }
}
