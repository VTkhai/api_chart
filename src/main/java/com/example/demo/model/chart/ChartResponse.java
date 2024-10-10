package com.example.demo.model.chart;

import com.example.demo.enums.ResolutionString;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChartResponse {
    private Long id;

    private String name;

    private ResolutionString resolution;

    private String symbol;

    private LocalDateTime timestamp;

    private String content;
}