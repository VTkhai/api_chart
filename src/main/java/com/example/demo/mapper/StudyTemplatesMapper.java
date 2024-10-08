package com.example.demo.mapper;

import com.example.demo.entity.ChartTemplates;
import com.example.demo.entity.StudyTemplates;
import com.example.demo.model.chart_templates.ChartTemplatesRequest;
import com.example.demo.model.chart_templates.ChartTemplatesResponse;
import com.example.demo.model.study_template.StudyTemplatesRequest;
import com.example.demo.model.study_template.StudyTemplatesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudyTemplatesMapper {
    StudyTemplatesMapper INSTANCE = Mappers.getMapper(StudyTemplatesMapper.class);

    StudyTemplatesResponse toResponse(StudyTemplates chartTemplates);

    StudyTemplates toEntity(StudyTemplatesRequest studyTemplatesRequest);

    void updateStudyTemplatesFromRequest(StudyTemplatesRequest studyTemplatesRequest,
                                         @MappingTarget StudyTemplates studyTemplates);

    default StudyTemplatesResponse toBodyResponse(StudyTemplates studyTemplates) {
        StudyTemplatesResponse response = new StudyTemplatesResponse();
        response.setName(studyTemplates.getName());
        response.setContent(studyTemplates.getContent());
        return response;
    }
}
