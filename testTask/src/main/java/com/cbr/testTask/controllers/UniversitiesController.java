package com.cbr.testTask.controllers;

import com.cbr.testTask.db.UniversitiesEntity;
import com.cbr.testTask.services.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversitiesController {
    private final UniversityService universityService;
    @Autowired
    public UniversitiesController(UniversityService universityService){
        this.universityService = universityService;
    }
    @GetMapping
    public List<UniversitiesEntity> getAllUniversities(){
        return universityService.findAllUniversity();
    }
    @GetMapping("/{id}")
    public UniversitiesEntity getUniversity(@PathVariable("id") Long id){
        return universityService.findOne(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        universityService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                                 @Valid @RequestBody UniversitiesEntity updateUniversity){
        universityService.update(id, updateUniversity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody UniversitiesEntity universitiesEntity){
        universityService.save(universitiesEntity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
