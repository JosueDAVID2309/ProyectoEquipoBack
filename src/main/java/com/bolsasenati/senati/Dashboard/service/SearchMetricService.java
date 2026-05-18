package com.senati.bolsa.service;

import com.senati.bolsa.model.SearchMetric;
import java.util.List;
import java.util.Map;

public interface SearchMetricService {
    List<SearchMetric> getTop10MostViewed();
    List<Object[]> getViewsGroupedByDay();
    Map<String, Object> getDashboardData();
}