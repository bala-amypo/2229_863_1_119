package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;

    public RiskThresholdController(RiskThresholdService riskThresholdService) {
        this.riskThresholdService = riskThresholdService;
    }

    @PostMapping("/{portfolioId}")
    public RiskThreshold setThreshold(@PathVariable Long portfolioId, @RequestBody RiskThreshold threshold) {
        return riskThresholdService.setThreshold(portfolioId, threshold);
    }

    @GetMapping("/{portfolioId}")
    public RiskThreshold getThreshold(@PathVariable Long portfolioId) {
        return riskThresholdService.getThresholdForPortfolio(portfolioId);
    }
}
