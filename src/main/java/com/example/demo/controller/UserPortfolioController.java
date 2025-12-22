package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService userPortfolioService;

    public UserPortfolioController(UserPortfolioService userPortfolioService) {
        this.userPortfolioService = userPortfolioService;
    }

    @PostMapping
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio) {
        return userPortfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/{id}")
    public UserPortfolio getPortfolioById(@PathVariable Long id) {
        return userPortfolioService.getPortfolioById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPortfolio> getPortfoliosByUser(@PathVariable Long userId) {
        return userPortfolioService.getPortfoliosByUser(userId);
    }
}
