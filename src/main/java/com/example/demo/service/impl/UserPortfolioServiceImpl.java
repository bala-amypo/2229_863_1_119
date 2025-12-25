package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repository;

    // ⚠️ Exact constructor
    public UserPortfolioServiceImpl(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        UserPortfolio existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        existing.setPortfolioName(portfolio.getPortfolioName());
        return repository.save(existing);
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deactivatePortfolio(Long id) {
        UserPortfolio p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        p.setActive(false);
        repository.save(p);
    }
}
