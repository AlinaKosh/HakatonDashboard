package com.cbr.testTask.services;

import com.cbr.testTask.db.AchievementEntity;

import com.cbr.testTask.repo.AchievementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AchievementService {
    private final AchievementRepository achievementRepository;

    @Autowired
    public AchievementService(AchievementRepository achievementRepository){
        this.achievementRepository = achievementRepository;
    }
    public List<AchievementEntity> findAllAchievement(){return achievementRepository.findAll();}

    public AchievementEntity findOne(Long id){
        return achievementRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(AchievementEntity achievementEntity){
        achievementRepository.save(achievementEntity);
    }
    @Transactional
    public void update(Long id, AchievementEntity achievementEntity){
        achievementEntity.setId(id);
        achievementRepository.save(achievementEntity);
    }
    @Transactional
    public void delete(Long id){
        achievementRepository.deleteById(id);
    }
}
