package edu.upc.gessi.glidebackend.service;

import edu.upc.gessi.glidebackend.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto createSubject(SubjectDto subjectDto);

    SubjectDto getSubjectById(Long subjectId);

    List<SubjectDto> getAllSubjects();

    SubjectDto updateSubject(Long subjectId, SubjectDto updatedSubjectDto);

    void deleteSubject(Long subjectId);
}
