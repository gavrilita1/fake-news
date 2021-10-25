package com.example.fakenews.service;

import com.example.fakenews.entity.Check;

import java.util.List;

public interface iCheckService {

    Check saveCheck(Check check);
    Check updateCheck(Check check);
    List<Check> getAllChecks();
    Check getCheck(Long checkId);
    void deleteCheck(Long checkId);
}
