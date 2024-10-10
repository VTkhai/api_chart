package com.example.demo.model.chart;

import com.example.demo.enums.ResolutionString;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ChartRequest {
    private String name;

    private ResolutionString resolution;

    private String symbol;

    private LocalDateTime timestamp;

    private String content;
}