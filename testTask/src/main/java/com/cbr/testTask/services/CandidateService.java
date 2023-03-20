package com.cbr.testTask.services;

import com.cbr.testTask.db.*;
import com.cbr.testTask.repo.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public List<CandidatesEntity> findByCompetitionId(long id){
        return candidateRepository.findAll().stream()
                .filter(candidatesEntity -> {
                    for (CandidateToAdditionalCompetitionEntity ace : candidatesEntity.getAdditionalCompetitionId()){
                        if (ace.getAdditionalId().getId() == id)
                            return true;
                    }
                    return false;
                }).collect(Collectors.toList());
    }

    public List<CandidatesEntity> findAll(){
        return candidateRepository.findAll();
    }
    @Transactional
    public void create(CandidatesEntity candidates){
        candidateRepository.save(candidates);
    }
}
