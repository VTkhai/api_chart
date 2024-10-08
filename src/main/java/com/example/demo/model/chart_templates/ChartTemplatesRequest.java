package com.example.demo.model.chart_templates;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChartTemplatesRequest {
    private String name;

    private String content;
}
