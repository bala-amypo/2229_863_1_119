package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService service;

    public RiskAnalysisController(RiskAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskAnalysisResult> analyze(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(service.analyzePortfolio(portfolioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAnalysisResult> getAnalysis(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAnalysisById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalyses(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(service.getAnalysesForPortfolio(portfolioId));
    }
}
