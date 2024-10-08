package com.example.demo.model.study_template;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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
}
