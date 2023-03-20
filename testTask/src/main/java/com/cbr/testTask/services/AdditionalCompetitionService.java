package com.cbr.testTask.services;

import com.cbr.testTask.db.AdditionalCompetitionEntity;
import com.cbr.testTask.repo.AdditionalCompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AdditionalCompetitionService {
    private final AdditionalCompetitionRepository additionalCompetitionRepository;

    @Autowired
    public AdditionalCompetitionService(AdditionalCompetitionRepository additionalCompetitionRepository) {
        this.additionalCompetitionRepository = additionalCompetitionRepository;
    }

    public List<AdditionalCompetitionEntity> findAllCompetition(){
        return additionalCompetitionRepository.findAll();
    }

    public AdditionalCompetitionEntity findOne(Long id){
        return additionalCompetitionRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(AdditionalCompetitionEntity additionalCompetitionEntity){
        additionalCompetitionRepository.save(additionalCompetitionEntity);
    }

    @Transactional
    public void update(Long id, AdditionalCompetitionEntity updateAdditional){
        updateAdditional.setId(id);
        additionalCompetitionRepository.save(updateAdditional);
    }

    @Transactional
    public void delete(Long id){
        additionalCompetitionRepository.deleteById(id);
    }
}
