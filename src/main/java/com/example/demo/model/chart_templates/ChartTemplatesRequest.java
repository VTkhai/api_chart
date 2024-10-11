package com.example.demo.model.chart_templates;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChartTemplatesRequest {
    private String content;

    private String chartProperties;

    private String mainSourceProperties;

    private Integer version;
}
