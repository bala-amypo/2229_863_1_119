package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(service.createThreshold(threshold));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskThreshold> updateThreshold(
            @PathVariable Long id,
            @RequestBody RiskThreshold threshold
    ) {
        return ResponseEntity.ok(service.updateThreshold(id, threshold));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long id) {
        return ResponseEntity.ok(service.getThresholdById(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        return ResponseEntity.ok(service.getAllThresholds());
    }
}
