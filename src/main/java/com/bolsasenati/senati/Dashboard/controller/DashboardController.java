package com.bolsasenati.senati.dashboard.controller;

import com.bolsasenati.senati.dashboard.service.SearchMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/instructor/dashboard")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"}) // Permite conectar con tu frontend
public class DashboardController {

    @Autowired
    private SearchMetricService searchMetricService;

    @GetMapping("/metrics")
    public ResponseEntity<Map<String, Object>> getDashboardData() {
        Map<String, Object> response = searchMetricService.getDashboardData();
        return ResponseEntity.ok(response);
    }
}