package edu.upc.gessi.glidebackend.service;

import edu.upc.gessi.glidebackend.dto.StudentUserDto;

public interface StudentService {
    StudentUserDto getStudent(String idToken);
}
