package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));

        existing.setMinValue(threshold.getMinValue());
        existing.setMaxValue(threshold.getMaxValue());
        existing.setRiskLevel(threshold.getRiskLevel());

        return repository.save(existing);
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return repository.findAll();
    }

    @Override
    public void deleteThreshold(Long id) {
        repository.deleteById(id);
    }
}
