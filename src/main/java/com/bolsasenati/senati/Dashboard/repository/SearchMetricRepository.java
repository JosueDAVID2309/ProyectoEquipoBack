package com.bolsasenati.senati.dashboard.repository;

import com.bolsasenati.senati.dashboard.model.SearchMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchMetricRepository extends JpaRepository<SearchMetric, Long> {

    
    List<SearchMetric> findTop10ByOrderByViewsCountDesc();

    
    @Query("SELECT FUNCTION('DAYNAME', s.searchDate), SUM(s.viewsCount) " +
           "FROM SearchMetric s GROUP BY FUNCTION('DAYNAME', s.searchDate)")
    List<Object[]> getViewsGroupedByDay();
}