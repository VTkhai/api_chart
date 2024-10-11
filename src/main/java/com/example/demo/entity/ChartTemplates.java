package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "chart_templates")
@Schema(description = "Chart Templates Model")
public class ChartTemplates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Id Chart Template", example = "1")
    private Long id;

    @Column(name = "content", columnDefinition = "JSON", nullable = true)
    private String content;

    @Column(name = "chart_properties", columnDefinition = "JSON", nullable = true)
    private String chartProperties;

    @Column(name = "main_source_properties", columnDefinition = "JSON", nullable = true)
    private String mainSourceProperties;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
