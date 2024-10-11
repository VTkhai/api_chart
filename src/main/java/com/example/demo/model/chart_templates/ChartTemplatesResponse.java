package com.example.demo.model.chart_templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChartTemplatesResponse {
    private Long id;

    private String content;

    private String chartProperties;

    private String mainSourceProperties;

    private Integer version;

    private Instant createdAt;

    private Instant updatedAt;
}
