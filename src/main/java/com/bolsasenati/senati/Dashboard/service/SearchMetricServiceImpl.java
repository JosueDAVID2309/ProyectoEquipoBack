package com.senati.bolsa.service.impl;

import com.senati.bolsa.model.SearchMetric;
import com.senati.bolsa.repository.SearchMetricRepository;
import com.senati.bolsa.service.SearchMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchMetricServiceImpl implements SearchMetricService {

    @Autowired
    private SearchMetricRepository searchMetricRepository;

    @Override
    public List<SearchMetric> getTop10MostViewed() {
        return searchMetricRepository.findTop10ByOrderByViewsCountDesc();
    }

    @Override
    public List<Object[]> getViewsGroupedByDay() {
        return searchMetricRepository.getViewsGroupedByDay();
    }

    @Override
    public Map<String, Object> getDashboardData() {
        Map<String, Object> dashboardData = new HashMap<>();
        
        // Reunimos ambas consultas en un solo llamado estructurado
        dashboardData.put("topMetrics", this.getTop10MostViewed());
        dashboardData.put("chartData", this.getViewsGroupedByDay());
        
        return dashboardData;
    }
}