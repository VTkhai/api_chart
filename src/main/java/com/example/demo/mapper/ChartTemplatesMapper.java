package com.example.demo.mapper;

import com.example.demo.entity.Chart;
import com.example.demo.entity.ChartTemplates;
import com.example.demo.model.chart.ChartResponse;
import com.example.demo.model.chart_templates.ChartTemplatesRequest;
import com.example.demo.model.chart_templates.ChartTemplatesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChartTemplatesMapper {

    ChartTemplatesMapper INSTANCE = Mappers.getMapper(ChartTemplatesMapper.class);

    // Mapping from entity to response
    ChartTemplatesResponse toResponse(ChartTemplates chartTemplate);

    // Mapping from request to entity
    ChartTemplates toEntity(ChartTemplatesRequest chartTemplateRequest);

    // Update an existing entity from a request
    void updateChartTemplatesFromRequest(ChartTemplatesRequest chartTemplateRequest,
                                        @MappingTarget ChartTemplates chartTemplate);

    // Custom method to map entity to a simplified body response
    default ChartTemplatesResponse toBodyResponse(ChartTemplates chartTemplate) {
        ChartTemplatesResponse response = new ChartTemplatesResponse();
        response.setId(chartTemplate.getId());
        response.setContent(chartTemplate.getContent());
        response.setChartProperties(chartTemplate.getChartProperties());
        response.setMainSourceProperties(chartTemplate.getMainSourceProperties());
        response.setVersion(chartTemplate.getVersion());
        response.setCreatedAt(chartTemplate.getCreatedAt());
        response.setUpdatedAt(chartTemplate.getUpdatedAt());
        return response;
    }
}
