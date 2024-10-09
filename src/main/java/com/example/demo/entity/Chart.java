package com.example.demo.entity;

import com.example.demo.enums.ResolutionString;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    private String content;

    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ResolutionString resolution;

    private String symbol;

    private Long timestamp;
}
