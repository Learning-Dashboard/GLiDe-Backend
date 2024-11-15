package edu.upc.gessi.glidebackend.controller;

import edu.upc.gessi.glidebackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/login")
    public ResponseEntity<?> postLogin(@RequestHeader(HttpHeaders.AUTHORIZATION) String idToken) {
        studentService.getStudent(idToken);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
