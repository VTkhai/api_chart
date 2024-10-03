package com.example.demo.mapper;

import com.example.demo.entity.Chart;
import com.example.demo.model.ChartRequest;
import com.example.demo.model.ChartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChartMapper {

    ChartMapper INSTANCE = Mappers.getMapper(ChartMapper.class);

    ChartResponse toResponse(Chart chart);

    Chart toEntity(ChartRequest chartRequest);

    void updateChartFromRequest(ChartRequest chartRequest, @MappingTarget Chart chart);
}
