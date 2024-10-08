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

    ChartTemplatesResponse toResponse(ChartTemplates chartTemplates);

    ChartTemplates toEntity(ChartTemplatesRequest chartTemplatesRequest);

    void updateChartTemplatesFromRequest(ChartTemplatesRequest chartTemplatesRequest,
                                         @MappingTarget ChartTemplates chartTemplates);
    default ChartTemplatesResponse toBodyResponse(ChartTemplates chartTemplates) {
        ChartTemplatesResponse response = new ChartTemplatesResponse();
        response.setName(chartTemplates.getName());
        response.setContent(chartTemplates.getContent());
        return response;
    }

}
