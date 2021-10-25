package com.example.fakenews.service;

import com.example.fakenews.entity.Check;
import com.example.fakenews.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CheckService implements iCheckService {

    @Autowired
    CheckRepository checkRepository;

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
        existingCheck.setCheckDate(check.getCheckDate());
        existingCheck.setCheckUrl(check.getCheckUrl());
        existingCheck.setTweetId(check.getTweetId());
        existingCheck.setVerdict(check.getVerdict());
        existingCheck.setReason(check.getReason());
        return checkRepository.save(existingCheck);
    }

    @Override
    public void deleteCheck(Long checkId) {
        checkRepository.deleteById(checkId);
    }
}
