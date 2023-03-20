package com.cbr.testTask.services;

import com.cbr.testTask.db.ChosenCandidateEntity;
import com.cbr.testTask.repo.ChosenCandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ChosenCandidateService {
    private final ChosenCandidateRepository chosenCandidateRepository;

    @Autowired
    public ChosenCandidateService(ChosenCandidateRepository chosenCandidateRepository){
        this.chosenCandidateRepository = chosenCandidateRepository;
    }
    public List<ChosenCandidateEntity> findAllChosenCandidate(){return chosenCandidateRepository.findAll();}

    public ChosenCandidateEntity findOne(Long id){
        return chosenCandidateRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(ChosenCandidateEntity chosenCandidateEntity){
        chosenCandidateRepository.save(chosenCandidateEntity);
    }
    @Transactional
    public void update(Long id, ChosenCandidateEntity chosenCandidateEntity){
        chosenCandidateEntity.setId(id);
        chosenCandidateRepository.save(chosenCandidateEntity);
    }
    @Transactional
    public void delete(Long id){
        chosenCandidateRepository.deleteById(id);
    }
}
