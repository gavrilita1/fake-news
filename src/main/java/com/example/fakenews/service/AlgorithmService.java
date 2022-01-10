package com.example.fakenews.service;

import com.example.fakenews.entity.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.UsersResources;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;


@Service
@CrossOrigin(origins = "*")
public class AlgorithmService{

    public int score = 100;
    public List<String> reason = new ArrayList<String>();
    @Autowired
    private CheckService checkService;


    public AlgorithmService algorithmRun(Status status, UsersResources user) throws TwitterException {

        AlgorithmService run = new AlgorithmService();

        String account=status.getUser().getScreenName();
        String text = status.getText();
        int retweetCount = status.getRetweetCount();
        int likeCount = status.getFavoriteCount();

        User userName = user.showUser(account);
        Date createdAtUser = userName.getCreatedAt();
        int followersCount =  userName.getFollowersCount();
        boolean isValid = userName.isVerified();


        likesCheck(likeCount, followersCount,run);
        retweetCheck(retweetCount, followersCount,run);
        hasExtremeWords(text,run);
        //hasRepetitiveStructures(text);
        dateCheck(createdAtUser,run);
        isVerified(isValid,run);

        long id=status.getId()%1000000000;
        checkUpdateHistory((int)id,run);

        if(run.score==100){
            run.reason.add("True");
        }

        return run;
    }

    public void likesCheck(int likeCount, int followersCount, AlgorithmService run){
        if(likeCount<(followersCount/20)){
            run.score-=10;
            run.reason.add("likesCheck");
        }
    }
    public void retweetCheck(int retweetCount, int followersCount, AlgorithmService run){
        if(retweetCount<(followersCount/1000)){
            run.score-=10;
            run.reason.add("retweetCheck");
        }
    }

    public void hasExtremeWords(String text, AlgorithmService run) {
        String[] extremePhrases = {"BREAKING", "JUST IN", "IMPOSSIBLE", "GUARANTEED", "100% TRUE", "SURE", "NEVER", "NEVER BEFORE SEEN", "NEVER SEEN"};
        boolean includesExtremePhrases = false;

        for(String phrase : extremePhrases) {
            if(text.contains(phrase)) {
                run.score -= 3;
                includesExtremePhrases = true;
            }
        }

        if(includesExtremePhrases){
            run.score -= 10;
            run.reason.add("hasExtremeWords");
        }
    }

    /*public void hasRepetitiveStructures(String text) {
        Map<String, Integer> map = new HashMap<>();

        // keeps track of how many times a word is repeated
        for (String string : text.split(" ")) {
            map.putIfAbsent(string, 0);
            map.put(string, map.get(string) + 1);
        }

        // if any of the strings are repeated 3 or more times, we subtract points
        for (Integer integer : map.values()) {
            if(map.get(integer).equals(3)) {
                this.score -= 5;
            }
            if(map.get(integer).equals(4)) {
                this.score -= 6;
            }
            if(map.get(integer).equals(5)) {
                this.score -= 7;
            }
        }
    }
     */



    public void dateCheck(Date createdAt, AlgorithmService run){
        //The user account has been created in the last 10 days.
        if(!checkDateLimit(createdAt, 10)){
            run.score -=20;
            run.reason.add("Account has less then 10 days");
        }
        //The user account has been created in the last 100 days.
        if(checkDateLimit(createdAt, 10) && !checkDateLimit(createdAt, 100)){
            run.score -=15;
            run.reason.add("Account has less then 100 days");
        }
        //The user account has been created in the last year.
        if(checkDateLimit(createdAt, 100) && !checkDateLimit(createdAt, 365)){
            run.score -=10;
            run.reason.add("Account has less then 1 year");
        }
    }

    boolean checkDateLimit(Date date, int days) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        long daysDif = ChronoUnit.DAYS.between(localDate, today);
        return daysDif > days;
    }


    public void isVerified(boolean isVerified, AlgorithmService run){
        if(isVerified){
            run.score+=10;
            run.reason.add("Account is verified");
        }
        else{
            run.score-=10;
            run.reason.add("Account is not verified");
        }
    }

    public void checkUpdateHistory(int id, AlgorithmService run){
        Check check = new Check(id,run.score,run.reason.toString());
        checkService.saveCheck(check);
    }
}
