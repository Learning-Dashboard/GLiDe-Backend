package edu.upc.gessi.glidebackend.mapper;

import edu.upc.gessi.glidebackend.dto.SubjectDto;
import edu.upc.gessi.glidebackend.entity.SubjectEntity;

public class SubjectMapper {
    public static SubjectDto mapToSubjectDto(SubjectEntity subjectEntity) {
        return new SubjectDto(
                subjectEntity.getId(),
                subjectEntity.getName(),
                subjectEntity.getAcronym(),
                subjectEntity.getCode(),
                subjectEntity.getStudies(),
                subjectEntity.getSchool()
        );
    }

    public static SubjectEntity mapToSubjectEntity(SubjectDto subjectDto) {
        return new SubjectEntity(
                subjectDto.getId(),
                subjectDto.getName(),
                subjectDto.getAcronym(),
                subjectDto.getCode(),
                subjectDto.getStudies(),
                subjectDto.getSchool()
        );
    }
}
