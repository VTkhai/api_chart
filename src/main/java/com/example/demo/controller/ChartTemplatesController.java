package com.example.demo.controller;

import com.example.demo.entity.ChartTemplates;
import com.example.demo.model.chart.ChartResponse;
import com.example.demo.model.chart_templates.ChartTemplatesRequest;
import com.example.demo.model.chart_templates.ChartTemplatesResponse;
import com.example.demo.service.ChartTemplatesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/chartTemplates")
@Tag(name = "Chart Templates")
public class ChartTemplatesController {
    @Autowired
    private ChartTemplatesService chartTemplatesService;

    @Operation(summary = "Get Chart Templates Details", description = "Get chart Templates details")
    @GetMapping("/{id}")
    public ResponseEntity<ChartTemplatesResponse> chartTemplatesDetails (@Valid @PathVariable(name = "id")Long id){
        ChartTemplatesResponse chartTemplatesResponse = chartTemplatesService.getChartTemplatesDetails(id);
        return ResponseEntity.ok(chartTemplatesResponse);
    }

    @Operation(summary = "Get Chart Templates List", description = "Get all chart Templates")
    @GetMapping
    public ResponseEntity<List<ChartTemplatesResponse>> getAllChartsTemplates(){
        List<ChartTemplatesResponse> chartTemplates = chartTemplatesService.getAllChartTemplates();
        return ResponseEntity.ok(chartTemplates);
    }

    @Operation(summary = "Create Chart Templates", description = "Create new Chart Templates")
    @PostMapping
    public  ResponseEntity<ChartTemplatesResponse> createChartTemplates(
            @Valid
            @RequestBody ChartTemplatesRequest chartTemplatesRequest){
        ChartTemplatesResponse chartTemplatesResponse = chartTemplatesService.createChartTemplates(chartTemplatesRequest);
        return ResponseEntity.ok(chartTemplatesResponse);
    }

    @Operation(summary = "Update Chart Templates", description = "Update Chart Templates Existing")
    @PutMapping("/{id}")
    public ResponseEntity<ChartTemplatesResponse> updateChartTemplates(@Valid
                                                     @PathVariable(name = "id") Long id,
                                                     @RequestBody ChartTemplatesRequest chartTemplatesRequest){
        ChartTemplatesResponse chartTemplatesResponse = chartTemplatesService.updateChartTemplates(id, chartTemplatesRequest);
        return ResponseEntity.ok(chartTemplatesResponse);
    }

    @Operation(summary = "Delete Chart Templates", description = "Delete Chart Templates Existing")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChartTemplates(@PathVariable Long id){
        chartTemplatesService.deleteChartTemplates(id);
        return  ResponseEntity.ok(null);
    }

    @Operation(summary = "Get body of Chart Templates", description = "Get chart Templates body")
    @GetMapping("/{id}/body")
    public ResponseEntity<ChartTemplatesResponse> getChartTemplatesBody(@PathVariable Long id) {
        ChartTemplatesResponse chartTemplatesResponse = chartTemplatesService.getChartTemplatesBody(id);
        return ResponseEntity.ok(chartTemplatesResponse);
    }
}
