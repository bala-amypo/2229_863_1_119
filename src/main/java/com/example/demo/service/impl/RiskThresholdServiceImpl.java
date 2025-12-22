package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository riskThresholdRepository;
    private final UserPortfolioRepository userPortfolioRepository;

    public RiskThresholdServiceImpl(RiskThresholdRepository riskThresholdRepository,
            UserPortfolioRepository userPortfolioRepository) {
        this.riskThresholdRepository = riskThresholdRepository;
        this.userPortfolioRepository = userPortfolioRepository;
    }

    @Override
    public RiskThreshold setThreshold(Long portfolioId, RiskThreshold threshold) {
        UserPortfolio portfolio = userPortfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

        if (threshold.getMaxSingleStockPercentage() < 0 || threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Max single stock percentage must be between 0 and 100");
        }

        threshold.setPortfolio(portfolio);
        return riskThresholdRepository.save(threshold);
    }

    @Override
    public RiskThreshold getThresholdForPortfolio(Long portfolioId) {
      
        return riskThresholdRepository.findAll().stream()
                .filter(rt -> rt.getPortfolio().getId().equals(portfolioId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Risk Threshold not found for portfolio"));
    }
}
