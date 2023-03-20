package com.cbr.testTask.controllers;

import com.cbr.testTask.db.ProfessionEntity;
import com.cbr.testTask.services.ProfessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    private final ProfessionService professionService;

    @Autowired
    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @GetMapping()
    public List<ProfessionEntity> getAllProfession(){
        return professionService.findAllProfession();
    }

    @GetMapping("/{id}")
    public ProfessionEntity getProfession(@PathVariable("id") Long id){
        return professionService.findOneProfession(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        professionService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                             @Valid @RequestBody ProfessionEntity updateProfession){
        professionService.update(id, updateProfession);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody ProfessionEntity professionEntity){
        professionService.save(professionEntity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
