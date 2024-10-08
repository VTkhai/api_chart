package com.example.demo.model.chart;

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

    private String resolution;

    private String symbol;

    private Long timestamp;
}