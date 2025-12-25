package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service   // ⭐⭐⭐ THIS FIXES EVERYTHING
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository analysisRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final PortfolioHoldingRepository holdingRepo;
    private final RiskThresholdRepository thresholdRepo;

    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository analysisRepo,
            UserPortfolioRepository portfolioRepo,
            PortfolioHoldingRepository holdingRepo,
            RiskThresholdRepository thresholdRepo
    ) {
        this.analysisRepo = analysisRepo;
        this.portfolioRepo = portfolioRepo;
        this.holdingRepo = holdingRepo;
        this.thresholdRepo = thresholdRepo;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult r = new RiskAnalysisResult();
        r.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        r.setHighRisk(false);
        return analysisRepo.save(r);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return analysisRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepo.findByPortfolioId(portfolioId);
    }
}
