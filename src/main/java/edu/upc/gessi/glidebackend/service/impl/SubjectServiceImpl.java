package edu.upc.gessi.glidebackend.service.impl;

import edu.upc.gessi.glidebackend.dto.SubjectDto;
import edu.upc.gessi.glidebackend.entity.SubjectEntity;
import edu.upc.gessi.glidebackend.excpetion.ResourceNotFoundException;
import edu.upc.gessi.glidebackend.mapper.SubjectMapper;
import edu.upc.gessi.glidebackend.repository.SubjectRepository;
import edu.upc.gessi.glidebackend.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        SubjectEntity subjectEntity = SubjectMapper.mapToSubjectEntity(subjectDto);
        SubjectEntity savedSubjectEntity= subjectRepository.save(subjectEntity);
        return SubjectMapper.mapToSubjectDto(savedSubjectEntity);
    }

    @Override
    public SubjectDto getSubjectById(Long subjectId) {
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject with id " + subjectId + " not found"));
        return SubjectMapper.mapToSubjectDto(subjectEntity);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        return subjectEntities.stream().map((subjectEntity) -> SubjectMapper.mapToSubjectDto(subjectEntity))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDto updateSubject(Long subjectId, SubjectDto updatedSubjectDto) {
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject with id " + subjectId + " not found"));
        subjectEntity.setAcronym(updatedSubjectDto.getAcronym());
        subjectEntity.setName(updatedSubjectDto.getName());
        subjectEntity.setCode(updatedSubjectDto.getCode());
        subjectEntity.setStudies(updatedSubjectDto.getStudies());
        subjectEntity.setSchool(updatedSubjectDto.getSchool());

        SubjectEntity updatedSubjectEntity = subjectRepository.save(subjectEntity);

        return SubjectMapper.mapToSubjectDto(updatedSubjectEntity);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject with id " + subjectId + " not found"));
        subjectRepository.deleteById(subjectId);
    }

}
