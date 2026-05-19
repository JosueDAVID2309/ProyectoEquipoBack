package com.bolsasenati.senati.dashboard.service;

import com.bolsasenati.senati.dashboard.model.SearchMetric;
import java.util.List;
import java.util.Map;

public interface SearchMetricService {
    List<SearchMetric> getTop10MostViewed();
    List<Object[]> getViewsGroupedByDay();
    Map<String, Object> getDashboardData();
}