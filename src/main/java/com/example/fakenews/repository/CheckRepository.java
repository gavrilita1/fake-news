package com.example.fakenews.repository;

import com.example.fakenews.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckRepository extends JpaRepository<Check, Long> {
    List<Check> findByUserId(long userId);
}