package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ChartResponse {
    private Long id;

    private String name;

    private String resolution;

    private String symbol;

    private Long timestamp;
}