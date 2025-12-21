package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService portfolioHoldingService;

    public PortfolioHoldingController(PortfolioHoldingService portfolioHoldingService) {
        this.portfolioHoldingService = portfolioHoldingService;
    }

    @PostMapping("/{portfolioId}/{stockId}")
    public PortfolioHolding addHolding(@PathVariable Long portfolioId, @PathVariable Long stockId,
            @RequestBody PortfolioHolding holding) {
        return portfolioHoldingService.addHolding(portfolioId, stockId, holding);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldingsByPortfolio(@PathVariable Long portfolioId) {
        return portfolioHoldingService.getHoldingsByPortfolio(portfolioId);
    }
}
