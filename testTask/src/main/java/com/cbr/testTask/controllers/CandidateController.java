package com.cbr.testTask.controllers;

import com.cbr.testTask.db.CandidatesEntity;
import com.cbr.testTask.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping("/all")
    public List<CandidatesEntity> findAll(){
        return candidateService.findAll();
    }

    @GetMapping("/{id}")
    public List<CandidatesEntity> findByCompetitionId(@PathVariable("id") long id){
        return candidateService.findByCompetitionId(id);
    }
}
