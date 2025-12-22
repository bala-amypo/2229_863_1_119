package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_portfolios")
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String portfolioName;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioHolding> portfolioHoldings;

    @OneToMany(mappedBy = "portfolio")
    private List<RiskAnalysisResult> riskAnalysisResults;

    public UserPortfolio() {
    }

    public UserPortfolio(User user, String portfolioName, LocalDateTime createdAt) {
        this.user = user;
        this.portfolioName = portfolioName;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<PortfolioHolding> getPortfolioHoldings() {
        return portfolioHoldings;
    }

    public void setPortfolioHoldings(List<PortfolioHolding> portfolioHoldings) {
        this.portfolioHoldings = portfolioHoldings;
    }

    public List<RiskAnalysisResult> getRiskAnalysisResults() {
        return riskAnalysisResults;
    }

    public void setRiskAnalysisResults(List<RiskAnalysisResult> riskAnalysisResults) {
        this.riskAnalysisResults = riskAnalysisResults;
    }
}
