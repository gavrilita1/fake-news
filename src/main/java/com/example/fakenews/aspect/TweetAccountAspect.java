package com.example.fakenews.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class TweetAccountAspect {

    // TweetAccountController.saveTweetAccount()
    @Before("execution(* com.example.fakenews.controller.TweetAccountController.saveTweetAccount(..))")
    public void beforeSaveTweetAccount() {
        System.out.println("TweetAccountController called saveTweetAccount()");
    }

    @After("execution(* com.example.fakenews.controller.TweetAccountController.saveTweetAccount(..))")
    public void afterSaveTweetAccount() {
        System.out.println("TweetAccountController finished executing saveTweetAccount()");
    }

    // TweetAccountController.addTweetAccounts()
    @Before("execution(* com.example.fakenews.controller.TweetAccountController.addTweetAccounts(..))")
    public void beforeAddTweetAccounts() {
        System.out.println("TweetAccountController called addTweetAccounts()");
    }
    @After("execution(* com.example.fakenews.controller.TweetAccountController.addTweetAccounts(..))")
    public void afterAddTweetAccounts() {
        System.out.println("TweetAccountController finished executing addTweetAccounts()");
    }

    // TweetAccountController.getAllTweetAccounts()
    @Before("execution(* com.example.fakenews.controller.TweetAccountController.getAllTweetAccounts(..))")
    public void beforeGetAllTweetAccounts() {
        System.out.println("TweetAccountController called getAllTweetAccounts()");
    }

    @After("execution(* com.example.fakenews.controller.TweetAccountController.getAllTweetAccounts(..))")
    public void afterGetAllTweetAccounts() {
        System.out.println("TweetAccountController finished executing getAllTweetAccounts()");
    }

    // TweetAccountController.getTweetAccount()
    @Before("execution(* com.example.fakenews.controller.TweetAccountController.getTweetAccount(..))")
    public void beforeGetTweetAccount() {
        System.out.println("TweetAccountController called getTweetAccount()");
    }

    @After("execution(* com.example.fakenews.controller.TweetAccountController.getTweetAccount(..))")
    public void afterGetTweetAccount() {
        System.out.println("TweetAccountController finished executing getTweetAccount()");
    }

    // TweetAccountController.updateTweetAccount()
    @Before("execution(* com.example.fakenews.controller.TweetAccountController.updateTweetAccount(..))")
    public void beforeUpdateTweetAccount() {
        System.out.println("TweetAccountController called updateTweetAccount()");
    }

    @After("execution(* com.example.fakenews.controller.TweetAccountController.updateTweetAccount(..))")
    public void afterUpdateTweetAccount() {
        System.out.println("TweetAccountController finished executing updateTweetAccount()");
    }

    // TweetAccountController.deleteTweetAccount()
    @Before("execution(* com.example.fakenews.controller.TweetAccountController.deleteTweetAccount(..))")
    public void beforeDeleteTweetAccount() {
        System.out.println("TweetAccountController called deleteTweetAccount()");
    }

    @After("execution(* com.example.fakenews.controller.TweetAccountController.deleteTweetAccount(..))")
    public void afterDeleteTweetAccount() {
        System.out.println("TweetAccountController finished executing deleteTweetAccount()");
    }
}
