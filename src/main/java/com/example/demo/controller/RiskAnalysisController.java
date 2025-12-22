package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService riskAnalysisService;

    public RiskAnalysisController(RiskAnalysisService riskAnalysisService) {
        this.riskAnalysisService = riskAnalysisService;
    }

    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult analyzePortfolio(@PathVariable Long portfolioId) {
        return riskAnalysisService.analyzePortfolio(portfolioId);
    }

    @GetMapping("/{portfolioId}")
    public List<RiskAnalysisResult> getAnalyses(@PathVariable Long portfolioId) {
        return riskAnalysisService.getAnalysesForPortfolio(portfolioId);
    }
}
