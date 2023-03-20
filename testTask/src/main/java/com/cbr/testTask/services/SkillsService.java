package com.cbr.testTask.services;

import com.cbr.testTask.db.SkillsEntity;
import com.cbr.testTask.repo.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SkillsService {
    private final SkillsRepository skillsRepository;

    @Autowired
    public SkillsService(SkillsRepository skillsRepository){
        this.skillsRepository = skillsRepository;
    }
    public List<SkillsEntity> findAllSkills(){return skillsRepository.findAll();}

    public SkillsEntity findOne(Long id){
        return skillsRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(SkillsEntity skillsEntity){
        skillsRepository.save(skillsEntity);
    }
    @Transactional
    public void update(Long id, SkillsEntity skillsEntity){
        skillsEntity.setId(id);
        skillsRepository.save(skillsEntity);
    }
    @Transactional
    public void delete(Long id){
        skillsRepository.deleteById(id);
    }
}
