package com.cbr.testTask.controllers;

import com.cbr.testTask.db.SkillsEntity;
import com.cbr.testTask.services.SkillsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    private final SkillsService skillsService;
    @Autowired
    public SkillsController(SkillsService skillsService){
        this.skillsService = skillsService;
    }
    @GetMapping
    public List<SkillsEntity> getAllSkills(){
        return skillsService.findAllSkills();
    }
    @GetMapping("/{id}")
    public SkillsEntity getSkill(@PathVariable("id") Long id){
        return skillsService.findOne(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        skillsService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                             @Valid @RequestBody SkillsEntity updateSkills){
        skillsService.update(id, updateSkills);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody SkillsEntity skills){
        skillsService.save(skills);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
