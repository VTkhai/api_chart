package com.example.demo.model.study_template;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudyTemplatesResponse {
    private Long id;

    private String content;

    private String name;

    private Instant createdAt;

    private Instant updatedAt;
}
