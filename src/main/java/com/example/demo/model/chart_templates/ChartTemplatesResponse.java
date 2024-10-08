package com.example.demo.model.chart_templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChartTemplatesResponse {
    private Long id;

    private String name;

    private String content;
}
