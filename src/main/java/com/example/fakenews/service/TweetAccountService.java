package com.example.fakenews.service;

import com.example.fakenews.entity.TweetAccount;
import com.example.fakenews.repository.TweetAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TweetAccountService implements iTweetAccountService {

    @Autowired
    TweetAccountRepository tweetAccountRepository;

    @Override
    public TweetAccount saveTweetAccount(TweetAccount tweetAccount) {
        return tweetAccountRepository.save(tweetAccount);
    }

    public List<TweetAccount> saveTweetAccounts(List<TweetAccount> tweetAccounts) {
        for (TweetAccount tweetAccount : tweetAccounts) {
            tweetAccountRepository.save(tweetAccount);
        }
        return tweetAccounts;
    }

    @Override
    public List<TweetAccount> getAllTweetAccounts() {
        return (List<TweetAccount>) tweetAccountRepository.findAll();
    }

    @Override
    public TweetAccount getTweetAccount(Long accountId) {
        return tweetAccountRepository.findById(accountId).get();
    }

    @Override
    public TweetAccount updateTweetAccount(TweetAccount tweetAccount) {
        TweetAccount existingTweetAccount = tweetAccountRepository.findById(tweetAccount.getAccountId()).orElse(null);
        existingTweetAccount.setAccountName(tweetAccount.getAccountName());
        existingTweetAccount.setFollowers(tweetAccount.getFollowers());
        existingTweetAccount.setJoinedDate(tweetAccount.getJoinedDate());
        existingTweetAccount.setTweetsIds(tweetAccount.getTweetsIds());
        return tweetAccountRepository.save(existingTweetAccount);
    }

    @Override
    public void deleteTweetAccount(Long accountId) {
        tweetAccountRepository.deleteById(accountId);
    }
}
