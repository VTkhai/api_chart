package com.example.demo.service.impl;

import com.example.demo.entity.Chart;
import com.example.demo.handle_exception.ResourceNotFoundException;
import com.example.demo.mapper.ChartMapper;
import com.example.demo.model.chart.ChartRequest;
import com.example.demo.model.chart.ChartResponse;
import com.example.demo.repository.ChartRepository;
import com.example.demo.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChartServiceimpl implements ChartService {
    @Autowired
    private ChartRepository chartRepository;

    @Override
    public List<ChartResponse> getAllCharts(){
        List<Chart> charts = chartRepository.findAll();
        return charts.stream().map(ChartMapper.INSTANCE::toResponse).collect(Collectors.toList());
    }
    @Override
    public ChartResponse getChartDetails(Long id){
        Chart chart = chartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chart with ID"+ id
                + "not found"));
       return ChartMapper.INSTANCE.toResponse(chart);
    }

    @Override
    public ChartResponse createChart(ChartRequest chartRequest){
        if(chartRequest == null){
            throw new RuntimeException("Cannot be null");
        }
        Chart chart = ChartMapper.INSTANCE.toEntity(chartRequest);

        Chart savedChart = chartRepository.save(chart);

       return ChartMapper.INSTANCE.toResponse(savedChart);
    }

    @Override
    public ChartResponse updateChart( Long id, ChartRequest chartRequest){
        Chart existingChart = chartRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Chart with id" + id + "not found"));
        ChartMapper.INSTANCE.updateChartFromRequest(chartRequest, existingChart);
        Chart updateChart = chartRepository.save(existingChart);
       return ChartMapper.INSTANCE.toResponse(updateChart);
    }

    @Override
    public void  deleteChart(Long id){
        Chart existingChart = chartRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Chart with id" + id + "not found"));
         chartRepository.delete(existingChart);
    }

    @Override
    public ChartResponse getChartName(Long id) {
        Chart chart = chartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chart with ID " + id + " not found"));
        return ChartMapper.INSTANCE.toNameResponse(chart);
    }

    @Override
    public ChartResponse getChartBody(Long id) {
        Chart chart = chartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chart with ID " + id + " not found"));
        return ChartMapper.INSTANCE.toBodyResponse(chart);
    }
}
