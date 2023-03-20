package com.cbr.testTask.controllers;

import com.cbr.testTask.db.EducationEntity;
import com.cbr.testTask.services.EducationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    private final EducationService educationService;
    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }
    @GetMapping
    public List<EducationEntity> getAllEducation(){
        return educationService.findAllEducation();
    }
    @GetMapping("/{id}")
    public EducationEntity getEducation(@PathVariable("id") Long id){
        return educationService.findOne(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        educationService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                             @Valid @RequestBody EducationEntity updateEducation){
        educationService.update(id, updateEducation);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody EducationEntity updateEducation){
        educationService.save(updateEducation);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
