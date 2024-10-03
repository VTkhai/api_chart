package com.example.demo.controller;

import com.example.demo.model.ChartRequest;
import com.example.demo.model.ChartResponse;
import com.example.demo.service.ChartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/chart")
@Tag(name = "Chart")
public class ChartController {
    @Autowired
    private ChartService chartService;

    @Operation(summary = "Get Chart Details", description = "Get chart details")
    @GetMapping("/{id}")
    public ResponseEntity<ChartResponse> chartDetails (@Valid @PathVariable(name = "id")Long id){
        ChartResponse chartResponse = chartService.getChartDetails(id);
        return ResponseEntity.ok(chartResponse);
    }

    @Operation(summary = "Get Chart List", description = "Get all chart")
    @GetMapping
    public ResponseEntity<List<ChartResponse>> getAllCharts(){
        List<ChartResponse> charts = chartService.getAllCharts();
        return ResponseEntity.ok(charts);
    }

    @Operation(summary = "Create Chart", description = "Create new Chart")
    @PostMapping
    public  ResponseEntity<ChartResponse> createChart(@Valid @RequestBody ChartRequest chartRequest){
        ChartResponse chartResponse = chartService.createChart(chartRequest);
        return ResponseEntity.ok(chartResponse);
    }

    @Operation(summary = "Update Chart", description = "Update Chart Existing")
    @PutMapping("/{id}")
    public ResponseEntity<ChartResponse> updateChart(@Valid
                                                     @PathVariable(name = "id") Long id,
                                                     @RequestBody ChartRequest chartRequest){
      ChartResponse chartResponse = chartService.updateChart(id, chartRequest);
      return ResponseEntity.ok(chartResponse);
    }

    @Operation(summary = "Delete Chart", description = "Delete Chart Existing")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChart(@PathVariable Long id){
        chartService.deleteChart(id);
        return  ResponseEntity.ok(null);
    }

}
