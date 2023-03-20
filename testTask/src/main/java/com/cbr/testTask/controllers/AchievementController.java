package com.cbr.testTask.controllers;

import com.cbr.testTask.db.AchievementEntity;
import com.cbr.testTask.services.AchievementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievement")
public class AchievementController {
    private final AchievementService achievementService;
    @Autowired
    public AchievementController(AchievementService achievementService){ this.achievementService = achievementService; }
    @GetMapping
    public List<AchievementEntity> getAllUniversities(){
        return achievementService.findAllAchievement();
    }
    @GetMapping("/{id}")
    public AchievementEntity getUniversity(@PathVariable("id") Long id){
        return achievementService.findOne(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        achievementService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                                @Valid @RequestBody AchievementEntity updateAchievment){
        achievementService.update(id, updateAchievment);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody AchievementEntity achievementEntity){
        achievementService.save(achievementEntity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
