package com.example.demo.service;

import com.example.demo.model.chart_templates.ChartTemplatesRequest;
import com.example.demo.model.chart_templates.ChartTemplatesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChartTemplatesService {
    List<ChartTemplatesResponse> getAllChartTemplates();

    ChartTemplatesResponse getChartTemplatesDetails(Long id);

    ChartTemplatesResponse createChartTemplates(ChartTemplatesRequest chartTemplatesRequest);

    ChartTemplatesResponse updateChartTemplates(Long id, ChartTemplatesRequest chartTemplatesRequest);

    void  deleteChartTemplates(Long id);

    ChartTemplatesResponse getChartTemplatesBody(Long id);
}
