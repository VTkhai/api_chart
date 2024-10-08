package com.example.demo.model.chart;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChartRequest {
    private String name;

    private String resolution;

    private String symbol;

    private Long timestamp;
}