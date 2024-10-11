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
@Table(name = "study_templates")
@Schema(description = "Study Templates Model")
public class StudyTemplates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Id Study Template", example = "1")
    private Long id;

    private String content;

    @Column(name = "name", nullable = false, length = 255)
    private String name;  // Template name, required and non-null

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;  // Automatically set timestamp for when the record is created

    @Column(name = "updated_at")
    private Instant updatedAt;  // Automatically updated timestamp for when the record is updated

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
