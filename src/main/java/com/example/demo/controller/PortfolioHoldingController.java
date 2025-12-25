package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holdings")
public class PortfolioHoldingController {

    private final PortfolioHoldingService service;

    public PortfolioHoldingController(PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PortfolioHolding> createHolding(@RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(service.createHolding(holding));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioHolding> updateHolding(
            @PathVariable Long id,
            @RequestBody PortfolioHolding holding
    ) {
        return ResponseEntity.ok(service.updateHolding(id, holding));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> getHolding(@PathVariable Long id) {
        return ResponseEntity.ok(service.getHoldingById(id));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getHoldings(@PathVariable Long portfolioId) {
        return ResponseEntity.ok(service.getHoldingsByPortfolio(portfolioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHolding(@PathVariable Long id) {
        service.deleteHolding(id);
        return ResponseEntity.ok().build();
    }
}
