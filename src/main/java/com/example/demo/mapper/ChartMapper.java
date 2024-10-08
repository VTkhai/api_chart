package com.example.demo.mapper;

import com.example.demo.entity.Chart;
import com.example.demo.model.chart.ChartRequest;
import com.example.demo.model.chart.ChartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChartMapper {

    ChartMapper INSTANCE = Mappers.getMapper(ChartMapper.class);

    ChartResponse toResponse(Chart chart);

    Chart toEntity(ChartRequest chartRequest);

    void updateChartFromRequest(ChartRequest chartRequest, @MappingTarget Chart chart);

    default ChartResponse toNameResponse(Chart chart) {
        ChartResponse response = new ChartResponse();
        response.setName(chart.getName()); // Giả sử ChartResponse có phương thức setName
        return response;
}
    default ChartResponse toBodyResponse(Chart chart) {
        ChartResponse response = new ChartResponse();
        response.setName(chart.getName());
        response.setResolution(chart.getResolution());
        response.setSymbol(chart.getSymbol());
        response.setTimestamp(chart.getTimestamp());// Giả sử ChartResponse có phương thức setName
        return response;
    }
}
