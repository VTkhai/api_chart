package com.example.demo.model.study_template;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudyTemplatesRequest {
    private String content;

    private String name;
}
