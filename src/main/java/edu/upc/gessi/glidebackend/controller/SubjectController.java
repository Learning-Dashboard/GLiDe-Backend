package edu.upc.gessi.glidebackend.controller;

import edu.upc.gessi.glidebackend.dto.SubjectDto;
import edu.upc.gessi.glidebackend.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private SubjectService subjectService;

    //Build Add Subject REST API
    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        SubjectDto savedSubjectDto= subjectService.createSubject(subjectDto);
        return new ResponseEntity<>(savedSubjectDto, HttpStatus.CREATED);
    }

    //Build Get Subject REST API
    @GetMapping("{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable("id") Long subjectId) {
        SubjectDto subjectDto = subjectService.getSubjectById(subjectId);
        return ResponseEntity.ok(subjectDto);
    }

    //Build Get All Subjects REST API
    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
        List<SubjectDto> subjectDtos = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjectDtos);
    }

    //Build Update Subject REST API
    @PutMapping("{id}")
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable("id") Long subjectId,
                                                    @RequestBody SubjectDto updatedSubjectDto) {
        SubjectDto subjectDto = subjectService.updateSubject(subjectId, updatedSubjectDto);
        return ResponseEntity.ok(subjectDto);
    }

    //Build Delete Subject REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("Successfully deleted subject with id " + subjectId);
    }


}
