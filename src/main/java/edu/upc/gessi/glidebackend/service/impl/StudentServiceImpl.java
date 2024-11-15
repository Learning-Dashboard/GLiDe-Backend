package edu.upc.gessi.glidebackend.service.impl;

import edu.upc.gessi.glidebackend.dto.StudentUserDto;
import edu.upc.gessi.glidebackend.entity.StudentUserEntity;
import edu.upc.gessi.glidebackend.excpetion.MissingInformationException;
import edu.upc.gessi.glidebackend.excpetion.ResourceNotFoundException;
import edu.upc.gessi.glidebackend.mapper.StudentUserMapper;
import edu.upc.gessi.glidebackend.repository.StudentUserRepository;
import edu.upc.gessi.glidebackend.service.AuthService;
import edu.upc.gessi.glidebackend.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentUserRepository studentUserRepository;
    @Autowired
    private AuthServiceImpl authService;

    @Override
    @Transactional
    public StudentUserDto getStudent(String idToken){
        if(idToken.isBlank())
            throw new MissingInformationException("No idToken was provided");
        String email = authService.getTokenMail(idToken);
        StudentUserEntity studentUserEntity = studentUserRepository.findById(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return StudentUserMapper.mapToStudentUserDto(studentUserEntity);
    }
}
