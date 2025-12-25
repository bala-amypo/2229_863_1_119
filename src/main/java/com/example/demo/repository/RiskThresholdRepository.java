package com.example.demo.repository;

import com.example.demo.model.RiskThreshold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {

    Optional<RiskThreshold> findByActiveTrue();
}
