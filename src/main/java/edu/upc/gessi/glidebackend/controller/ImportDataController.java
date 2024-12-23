package edu.upc.gessi.glidebackend.controller;

import edu.upc.gessi.glidebackend.service.ImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/importData")
@CrossOrigin(origins = "http://localhost:4201")
public class ImportDataController {

    @Autowired
    private ImportDataService importDataService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> importData(@RequestPart(value = "importedData") MultipartFile importedData,
                                 @RequestPart(value = "gameSubjectAcronym") String gameSubjectAcronym,
                                 @RequestPart(value = "gameCourse") Integer gameCourse,
                                 @RequestPart(value = "gamePeriod") String gamePeriod) {
        importDataService.importData(importedData, gameSubjectAcronym, gameCourse, gamePeriod);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
