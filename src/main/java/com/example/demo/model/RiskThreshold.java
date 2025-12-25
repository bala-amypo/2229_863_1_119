package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minValue;
    private Double maxValue;
    private String riskLevel;
    private boolean active;

    // ✅ REQUIRED BY TESTS
    private Double maxSingleStockPercentage;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public boolean isActive() {
        return active;
    }

    public Double getMaxSingleStockPercentage() {
        return maxSingleStockPercentage;
    }

    // ===== SETTERS =====
    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }
}
