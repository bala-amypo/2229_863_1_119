package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository riskAnalysisResultRepository;
    private final UserPortfolioRepository userPortfolioRepository;
    private final RiskThresholdService riskThresholdService;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository riskAnalysisResultRepository,
            UserPortfolioRepository userPortfolioRepository, RiskThresholdService riskThresholdService) {
        this.riskAnalysisResultRepository = riskAnalysisResultRepository;
        this.userPortfolioRepository = userPortfolioRepository;
        this.riskThresholdService = riskThresholdService;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = userPortfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));

       

        RiskThreshold threshold = riskThresholdService.getThresholdForPortfolio(portfolioId);

        
        Double calculatedHighestStockPercentage = 50.0; 

        Boolean isHighRisk = calculatedHighestStockPercentage > threshold.getMaxSingleStockPercentage();

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(LocalDateTime.now());
        result.setHighestStockPercentage(calculatedHighestStockPercentage);
        result.setIsHighRisk(isHighRisk);

        return riskAnalysisResultRepository.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return riskAnalysisResultRepository.findByPortfolioId(portfolioId);
    }
}
