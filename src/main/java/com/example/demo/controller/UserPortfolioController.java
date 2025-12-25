package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService service;

    public UserPortfolioController(UserPortfolioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(service.createPortfolio(portfolio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPortfolio> updatePortfolio(
            @PathVariable Long id,
            @RequestBody UserPortfolio portfolio
    ) {
        return ResponseEntity.ok(service.updatePortfolio(id, portfolio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPortfolioById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPortfolio>> getUserPortfolios(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getPortfoliosByUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivatePortfolio(@PathVariable Long id) {
        service.deactivatePortfolio(id);
        return ResponseEntity.ok().build();
    }
}
