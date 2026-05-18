package com.senati.bolsa.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "search_metrics")
@Data
public class SearchMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String jobRole;

    @Column(nullable = false)
    private LocalDate searchDate;

    @Column(nullable = false)
    private Integer viewsCount;
}