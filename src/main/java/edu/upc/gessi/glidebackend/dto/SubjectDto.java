package edu.upc.gessi.glidebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SubjectDto {
    private Long id;
    private String name;
    private String acronym;
    private String code;
    private String studies;
    private String school;
}
