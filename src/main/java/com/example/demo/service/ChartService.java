package com.example.demo.service;

import com.example.demo.model.chart.ChartRequest;
import com.example.demo.model.chart.ChartResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChartService {
    List<ChartResponse> getAllCharts();
    ChartResponse getChartDetails(Long id);
    ChartResponse createChart(ChartRequest chartRequest);
    ChartResponse updateChart(Long id, ChartRequest chartRequest);
    void deleteChart(Long id);

    ChartResponse getChartName(Long id);

    ChartResponse getChartBody(Long id);
}
