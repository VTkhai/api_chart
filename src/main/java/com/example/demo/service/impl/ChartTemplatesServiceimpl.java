package com.example.demo.service.impl;

import com.example.demo.entity.ChartTemplates;
import com.example.demo.handle_exception.ResourceNotFoundException;
import com.example.demo.mapper.ChartTemplatesMapper;
import com.example.demo.model.chart_templates.ChartTemplatesRequest;
import com.example.demo.model.chart_templates.ChartTemplatesResponse;
import com.example.demo.repository.ChartTemplatesRepository;
import com.example.demo.service.ChartTemplatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChartTemplatesServiceimpl implements ChartTemplatesService {
    @Autowired
    private ChartTemplatesRepository chartTemplatesRepository;

    @Override
    public List<ChartTemplatesResponse> getAllChartTemplates(){
        List<ChartTemplates> chartTemplates = chartTemplatesRepository.findAll();
        return chartTemplates.stream().map(ChartTemplatesMapper.INSTANCE::toResponse).collect(Collectors.toList());
    }

    @Override
    public ChartTemplatesResponse getChartTemplatesDetails(Long id){
        ChartTemplates chartTemplates = chartTemplatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ChartTemplates with ID"+ id + "not found"));
        return ChartTemplatesMapper.INSTANCE.toResponse(chartTemplates);
    }

    @Override
    public ChartTemplatesResponse createChartTemplates(ChartTemplatesRequest chartTemplatesRequest){
        if(chartTemplatesRequest == null){
            throw new RuntimeException("Cannot be null");
        }
        ChartTemplates chartTemplates = ChartTemplatesMapper.INSTANCE.toEntity(chartTemplatesRequest);

        ChartTemplates savedChartTemplates = chartTemplatesRepository.save(chartTemplates);

        return ChartTemplatesMapper.INSTANCE.toResponse(savedChartTemplates);
    }

    @Override
    public ChartTemplatesResponse updateChartTemplates(Long id, ChartTemplatesRequest chartTemplatesRequest){
        ChartTemplates existingChartTemplates = chartTemplatesRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Chart with id" + id + "not found"));
        ChartTemplatesMapper.INSTANCE.updateChartTemplatesFromRequest(chartTemplatesRequest, existingChartTemplates);
        ChartTemplates updateChartTemplates = chartTemplatesRepository.save(existingChartTemplates);
        return ChartTemplatesMapper.INSTANCE.toResponse(updateChartTemplates);
    }

    @Override
    public void  deleteChartTemplates(Long id){
        ChartTemplates existingChartTemplates = chartTemplatesRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Chart with id" + id + "not found"));
        chartTemplatesRepository.delete(existingChartTemplates);
    }

    @Override
    public ChartTemplatesResponse getChartTemplatesBody(Long id) {
        ChartTemplates chartTemplates = chartTemplatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chart with ID " + id + " not found"));
        return ChartTemplatesMapper.INSTANCE.toBodyResponse(chartTemplates);
    }
}
