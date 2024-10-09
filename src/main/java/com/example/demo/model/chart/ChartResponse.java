package com.example.demo.model.chart;

import com.example.demo.enums.ResolutionString;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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

    private Long timestamp;

    private String content;
}