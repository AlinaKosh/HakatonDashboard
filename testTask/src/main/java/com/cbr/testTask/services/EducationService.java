package com.cbr.testTask.services;

import com.cbr.testTask.db.EducationEntity;
import com.cbr.testTask.repo.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EducationService {
    private final EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository){
        this.educationRepository = educationRepository;
    }
    public List<EducationEntity> findAllEducation(){return educationRepository.findAll();}

    public EducationEntity findOne(Long id){
        return educationRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(EducationEntity educationEntity){
        educationRepository.save(educationEntity);
    }
    @Transactional
    public void update(Long id, EducationEntity educationEntity){
        educationEntity.setId(id);
        educationRepository.save(educationEntity);
    }
    @Transactional
    public void delete(Long id){
        educationRepository.deleteById(id);
    }
}
