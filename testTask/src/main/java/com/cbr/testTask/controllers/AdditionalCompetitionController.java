package com.cbr.testTask.controllers;

import com.cbr.testTask.db.AdditionalCompetitionEntity;
import com.cbr.testTask.services.AdditionalCompetitionService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competition")
public class AdditionalCompetitionController {

    private final AdditionalCompetitionService additionalCompetitionService;
    private final ModelMapper modelMapper;

    @Autowired
    public AdditionalCompetitionController(AdditionalCompetitionService additionalCompetitionService, ModelMapper modelMapper) {
        this.additionalCompetitionService = additionalCompetitionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<AdditionalCompetitionEntity> getAllCompetition(){
        return additionalCompetitionService.findAllCompetition();
    }

    @GetMapping("/{id}")
    public AdditionalCompetitionEntity getCompetition(@PathVariable("id") Long id){
        return additionalCompetitionService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        additionalCompetitionService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                             @Valid @RequestBody AdditionalCompetitionEntity updateCompetition){
        additionalCompetitionService.update(id, updateCompetition);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody AdditionalCompetitionEntity additionalCompetition){
        additionalCompetitionService.save(additionalCompetition);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
