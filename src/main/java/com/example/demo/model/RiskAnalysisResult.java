package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Timestamp analysisDate;

    private Double highestStockPercentage;

    private Double highestSectorPercentage;

    private Boolean isHighRisk;

    private String notes;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(UserPortfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Timestamp getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Timestamp analysisDate) {
        this.analysisDate = analysisDate;
    }

    public Double getHighestStockPercentage() {
        return highestStockPercentage;
    }

    public void setHighestStockPercentage(Double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Double getHighestSectorPercentage() {
        return highestSectorPercentage;
    }

    public void setHighestSectorPercentage(Double highestSectorPercentage) {
        this.highestSectorPercentage = highestSectorPercentage;
    }

    public Boolean isHighRisk() {
        return isHighRisk;
    }

    public void setHighRisk(Boolean highRisk) {
        isHighRisk = highRisk;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
