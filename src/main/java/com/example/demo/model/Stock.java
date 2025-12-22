package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ticker;

    private String companyName;
    private String sector;
    private Boolean isActive;

    @OneToMany(mappedBy = "stock")
    private List<PortfolioHolding> portfolioHoldings;

    public Stock() {
    }

    public Stock(String ticker, String companyName, String sector, Boolean isActive) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.sector = sector;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<PortfolioHolding> getPortfolioHoldings() {
        return portfolioHoldings;
    }

    public void setPortfolioHoldings(List<PortfolioHolding> portfolioHoldings) {
        this.portfolioHoldings = portfolioHoldings;
    }
}
