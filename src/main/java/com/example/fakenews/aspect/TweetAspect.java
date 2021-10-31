package com.example.fakenews.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class TweetAspect {

    // TweetController.saveTweet()
    @Pointcut("execution(* com.example.fakenews.controller.TweetController.saveTweet(..))")

    @Before("execution(* com.example.fakenews.controller.TweetController.saveTweet(..))")
    public void beforeSaveTweet() {
        System.out.println("TweetController called saveTweet()");
    }

    @After("execution(* com.example.fakenews.controller.TweetController.saveTweet(..))")
    public void afterSaveTweet() {
        System.out.println("TweetController finished executing saveTweet()");
    }

    // TweetController.addTweets()
    @Pointcut("execution(* com.example.fakenews.controller.TweetController.addTweets(..))")

    @Before("execution(* com.example.fakenews.controller.TweetController.addTweets(..))")
    public void beforeAddTweets() {
        System.out.println("TweetController called saveTweet()");
    }

    @After("execution(* com.example.fakenews.controller.TweetController.addTweets(..))")
    public void afterAddTweets() {
        System.out.println("TweetController finished executing saveTweet()");
    }

    // TweetController.getAllTweets()
    @Pointcut("execution(* com.example.fakenews.controller.TweetController.getAllTweets(..))")

    @Before("execution(* com.example.fakenews.controller.TweetController.getAllTweets(..))")
    public void beforeGetAllTweets() {
        System.out.println("TweetController called saveTweet()");
    }

    @After("execution(* com.example.fakenews.controller.TweetController.getAllTweets(..))")
    public void afterGetAllTweets() {
        System.out.println("TweetController finished executing saveTweet()");
    }

    // TweetController.getTweet()
    @Pointcut("execution(* com.example.fakenews.controller.TweetController.getTweet(..))")

    @Before("execution(* com.example.fakenews.controller.TweetController.getTweet(..))")
    public void beforeGetTweet() {
        System.out.println("TweetController called saveTweet()");
    }

    @After("execution(* com.example.fakenews.controller.TweetController.getTweet(..))")
    public void afterGetTweet() {
        System.out.println("TweetController finished executing saveTweet()");
    }

    // TweetController.updateTweet()
    @Pointcut("execution(* com.example.fakenews.controller.TweetController.updateTweet(..))")

    @Before("execution(* com.example.fakenews.controller.TweetController.updateTweet(..))")
    public void beforeUpdateTweet() {
        System.out.println("TweetController called saveTweet()");
    }

    @After("execution(* com.example.fakenews.controller.TweetController.updateTweet(..))")
    public void afterUpdateTweet() {
        System.out.println("TweetController finished executing saveTweet()");
    }

    // TweetController.deleteTweet()
    @Pointcut("execution(* com.example.fakenews.controller.TweetController.deleteTweet(..))")

    @Before("execution(* com.example.fakenews.controller.TweetController.deleteTweet(..))")
    public void beforeDeleteTweet() {
        System.out.println("TweetController called saveTweet()");
    }

    @After("execution(* com.example.fakenews.controller.TweetController.deleteTweet(..))")
    public void afterDeleteTweet() {
        System.out.println("TweetController finished executing saveTweet()");
    }
}
