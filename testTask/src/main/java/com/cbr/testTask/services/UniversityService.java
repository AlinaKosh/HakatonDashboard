package com.cbr.testTask.services;

import com.cbr.testTask.db.UniversitiesEntity;
import com.cbr.testTask.repo.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UniversityService {
    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository){
        this.universityRepository = universityRepository;
    }
    public List<UniversitiesEntity> findAllUniversity(){return universityRepository.findAll();}

    public UniversitiesEntity findOne(Long id){
        return universityRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(UniversitiesEntity universitiesEntity){
        universityRepository.save(universitiesEntity);
    }
    @Transactional
    public void update(Long id, UniversitiesEntity universitiesEntity){
        universitiesEntity.setId(id);
        universityRepository.save(universitiesEntity);
    }
    @Transactional
    public void delete(Long id){
        universityRepository.deleteById(id);
    }
}
