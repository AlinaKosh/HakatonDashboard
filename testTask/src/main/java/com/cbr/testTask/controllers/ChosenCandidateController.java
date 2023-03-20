package com.cbr.testTask.controllers;

import com.cbr.testTask.db.ChosenCandidateEntity;
import com.cbr.testTask.services.ChosenCandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chosenCandidate")
public class ChosenCandidateController {
    private final ChosenCandidateService chosenCandidateService;
    @Autowired
    public ChosenCandidateController(ChosenCandidateService chosenCandidateService){
        this.chosenCandidateService = chosenCandidateService;
    }
    @GetMapping
    public List<ChosenCandidateEntity> getAllChosenCandidateEntities(){
        return chosenCandidateService.findAllChosenCandidate();
    }
    @GetMapping("/{id}")
    public ChosenCandidateEntity getChosenCandidate(@PathVariable("id") Long id){
        return chosenCandidateService.findOne(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        chosenCandidateService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                             @Valid @RequestBody ChosenCandidateEntity updateChosenCandidate){
        chosenCandidateService.update(id, updateChosenCandidate);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody ChosenCandidateEntity chosenCandidatesEntity){
        chosenCandidateService.save(chosenCandidatesEntity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
