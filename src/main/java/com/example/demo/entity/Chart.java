package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "chart_entity")
@Schema(description = "Chart Model")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Id Chart", example = "1")
    private Long id;

    @Schema(description = "Chart name", example = "Chart coin")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Resolution cannot be empty")
    private String resolution;

    @NotEmpty(message = "Symbol cannot be empty")
    private String symbol;

    @Column(nullable = false)
    private Long timestamp;
}
