package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        return repository.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        holding.setId(id);
        return repository.save(holding);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PortfolioHolding not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }

    @Override
    public void deleteHolding(Long id) {
        repository.deleteById(id);   // ✅ ADD THIS
    }
}
