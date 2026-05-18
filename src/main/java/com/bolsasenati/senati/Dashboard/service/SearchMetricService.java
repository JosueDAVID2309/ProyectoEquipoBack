package com.bolsasenati.senati.Dashboard.service;

import com.bolsasenati.senati.Dashboard.model.SearchMetric;
import java.util.List;
import java.util.Map;

public interface SearchMetricService {
    List<SearchMetric> getTop10MostViewed();
    List<Object[]> getViewsGroupedByDay();
    Map<String, Object> getDashboardData();
}