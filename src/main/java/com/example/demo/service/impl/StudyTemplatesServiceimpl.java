package com.example.demo.service.impl;

import com.example.demo.entity.StudyTemplates;
import com.example.demo.handle_exception.ResourceNotFoundException;
import com.example.demo.mapper.StudyTemplatesMapper;
import com.example.demo.model.study_template.StudyTemplatesRequest;
import com.example.demo.model.study_template.StudyTemplatesResponse;
import com.example.demo.repository.StudyTemplatesRepository;
import com.example.demo.service.StudyTemplatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudyTemplatesServiceimpl implements StudyTemplatesService {
    @Autowired
    private StudyTemplatesRepository studyTemplatesRepository;

    @Override
    public List<StudyTemplatesResponse> getAllStudyTemplates(){
        List<StudyTemplates> studyTemplates = studyTemplatesRepository.findAll();
        return studyTemplates.stream().map(StudyTemplatesMapper.INSTANCE::toResponse).collect(Collectors.toList());
    }

    @Override
    public StudyTemplatesResponse getStudyTemplatesDetails(Long id){
        StudyTemplates studyTemplates = studyTemplatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudyTemplates with ID"+ id + "not found"));
        return StudyTemplatesMapper.INSTANCE.toResponse(studyTemplates);
    }

    @Override
    public StudyTemplatesResponse createStudyTemplates(StudyTemplatesRequest studyTemplatesRequest){
        if(studyTemplatesRequest == null){
            throw new RuntimeException("Cannot be null");
        }
        StudyTemplates studyTemplates = StudyTemplatesMapper.INSTANCE.toEntity(studyTemplatesRequest);

        StudyTemplates savedStudyTemplates = studyTemplatesRepository.save(studyTemplates);

        return StudyTemplatesMapper.INSTANCE.toResponse(savedStudyTemplates);
    }

    @Override
    public StudyTemplatesResponse updateStudyTemplates(Long id, StudyTemplatesRequest studyTemplatesRequest){
        StudyTemplates existingStudyTemplates = studyTemplatesRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Study with id" + id + "not found"));
        StudyTemplatesMapper.INSTANCE.updateStudyTemplatesFromRequest(studyTemplatesRequest, existingStudyTemplates);
        StudyTemplates updateStudyTemplates = studyTemplatesRepository.save(existingStudyTemplates);
        return StudyTemplatesMapper.INSTANCE.toResponse(updateStudyTemplates);
    }

    @Override
    public void  deleteStudyTemplates(Long id){
        StudyTemplates existingStudyTemplates = studyTemplatesRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Study with id" + id + "not found"));
        studyTemplatesRepository.delete(existingStudyTemplates);
    }

    @Override
    public StudyTemplatesResponse getStudyTemplatesBody(Long id) {
        StudyTemplates studyTemplates = studyTemplatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chart with ID " + id + " not found"));
        return StudyTemplatesMapper.INSTANCE.toBodyResponse(studyTemplates);
    }
}
