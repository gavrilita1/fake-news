package com.example.fakenews.repository;

import com.example.fakenews.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check, Long> {
}