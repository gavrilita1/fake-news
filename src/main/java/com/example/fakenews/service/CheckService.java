package com.example.fakenews.service;

import com.example.fakenews.entity.Check;
import com.example.fakenews.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.UsersResources;
import twitter4j.auth.AccessToken;

import java.util.List;


@Service
@CrossOrigin(origins = "*")
public class CheckService implements iCheckService {

    @Value("${consumerKeyStr}")
    private String consumerKeyStr;
    @Value("${consumerSecretStr}")
    private String consumerSecretStr;
    @Value("${accessTokenStr}")
    private String accessTokenStr;
    @Value("${accessTokenSecretStr}")
    private String accessTokenSecretStr;

    @Autowired
    CheckRepository checkRepository;
    @Autowired
    AlgorithmService algorithmService;

    public AlgorithmService tweetCheck(Long tweetId) throws TwitterException {

        final Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
        AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecretStr);
        twitter.setOAuthAccessToken(accessToken);

        long tweetID=tweetId;

        Status status = twitter.showStatus(tweetID);
        UsersResources user = twitter.users();
        AlgorithmService run = algorithmService.algorithmRun(status, user);


        return run;
    }


    @Override
    public Check saveCheck(Check check) {
        return checkRepository.save(check);
    }

    public List<Check> saveChecks(List<Check> checks) {
        for (Check check : checks) {
            checkRepository.save(check);
        }
        return checks;
    }

    @Override
    public List<Check> getAllChecks() {
        return (List<Check>) checkRepository.findAll();
    }

    @Override
    public Check getCheck (Long checkId) {
        return checkRepository.findById(checkId).get();
    }

    @Override
    public Check updateCheck(Check check) {
        Check existingCheck = checkRepository.findById(check.getCheckId()).orElse(null);
        //existingCheck.setTweetId(check.getTweetId());
        existingCheck.setVerdict(check.getVerdict());
        existingCheck.setReason(check.getReason());
        return checkRepository.save(existingCheck);
    }

    @Override
    public void deleteCheck(Long checkId) {
        checkRepository.deleteById(checkId);
    }
}
