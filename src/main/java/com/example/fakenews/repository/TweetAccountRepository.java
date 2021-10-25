package com.example.fakenews.repository;

import com.example.fakenews.entity.TweetAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetAccountRepository extends JpaRepository<TweetAccount, Long> {
}
