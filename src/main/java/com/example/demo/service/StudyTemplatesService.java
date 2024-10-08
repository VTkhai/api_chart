package com.example.demo.service;

import com.example.demo.model.study_template.StudyTemplatesRequest;
import com.example.demo.model.study_template.StudyTemplatesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudyTemplatesService {
    List<StudyTemplatesResponse> getAllStudyTemplates();

    StudyTemplatesResponse getStudyTemplatesDetails(Long id);

    StudyTemplatesResponse createStudyTemplates(StudyTemplatesRequest studyTemplatesRequest);

    StudyTemplatesResponse updateStudyTemplates(Long id, StudyTemplatesRequest studyTemplatesRequest);

    void  deleteStudyTemplates(Long id);

    StudyTemplatesResponse getStudyTemplatesBody(Long id);
}
