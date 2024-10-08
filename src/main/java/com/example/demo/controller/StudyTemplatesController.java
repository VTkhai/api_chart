package com.example.demo.controller;

import com.example.demo.model.chart_templates.ChartTemplatesRequest;
import com.example.demo.model.chart_templates.ChartTemplatesResponse;
import com.example.demo.model.study_template.StudyTemplatesRequest;
import com.example.demo.model.study_template.StudyTemplatesResponse;
import com.example.demo.service.StudyTemplatesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/studyTemplates")
@Tag(name = "Study Templates")
public class StudyTemplatesController {

    @Autowired
    private StudyTemplatesService studyTemplatesService;

    @Operation(summary = "Get Study Templates Details", description = "Get Study Templates details")
    @GetMapping("/{id}")
    public ResponseEntity<StudyTemplatesResponse> studyTemplatesDetails (@Valid @PathVariable(name = "id")Long id){
        StudyTemplatesResponse studyTemplatesResponse = studyTemplatesService.getStudyTemplatesDetails(id);
        return ResponseEntity.ok(studyTemplatesResponse);
    }

    @Operation(summary = "Get Study Templates List", description = "Get all Study Templates")
    @GetMapping
    public ResponseEntity<List<StudyTemplatesResponse>> getAllStudyTemplates(){
        List<StudyTemplatesResponse> studyTemplates = studyTemplatesService.getAllStudyTemplates();
        return ResponseEntity.ok(studyTemplates);
    }

    @Operation(summary = "Create Study Templates", description = "Create new Study Templates")
    @PostMapping
    public  ResponseEntity<StudyTemplatesResponse> createStudyTemplates(
            @Valid
            @RequestBody StudyTemplatesRequest studyTemplatesRequest){
        StudyTemplatesResponse studyTemplatesResponse = studyTemplatesService.createStudyTemplates(studyTemplatesRequest);
        return ResponseEntity.ok(studyTemplatesResponse);
    }

    @Operation(summary = "Update Study Templates", description = "Update Study Templates Existing")
    @PutMapping("/{id}")
    public ResponseEntity<StudyTemplatesResponse> updateStudyTemplates(@Valid
                                                                       @PathVariable(name = "id") Long id,
                                                                       @RequestBody StudyTemplatesRequest studyTemplatesRequest){
        StudyTemplatesResponse studyTemplatesResponse = studyTemplatesService.updateStudyTemplates(id, studyTemplatesRequest);
        return ResponseEntity.ok(studyTemplatesResponse);
    }

    @Operation(summary = "Delete Study Templates", description = "Delete Study Templates Existing")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyTemplates(@PathVariable Long id){
        studyTemplatesService.deleteStudyTemplates(id);
        return  ResponseEntity.ok(null);
    }

    @Operation(summary = "Get body of Study Templates", description = "Get study Templates body")
    @GetMapping("/{id}/body")
    public ResponseEntity<StudyTemplatesResponse> getStudyTemplatesBody(@PathVariable Long id) {
        StudyTemplatesResponse studyTemplatesResponse = studyTemplatesService.getStudyTemplatesBody(id);
        return ResponseEntity.ok(studyTemplatesResponse);
    }
}
