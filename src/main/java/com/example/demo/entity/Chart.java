package com.example.demo.entity;

import com.example.demo.enums.ResolutionString;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


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

    @NotNull
    private String content;
    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ResolutionString resolution;

    @NotNull
    private String symbol;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime timestamp;
}
