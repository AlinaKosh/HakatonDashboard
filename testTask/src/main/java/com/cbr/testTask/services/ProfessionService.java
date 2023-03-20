package com.cbr.testTask.services;

import com.cbr.testTask.db.ProfessionEntity;
import com.cbr.testTask.repo.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProfessionService {
    private final ProfessionRepository professionRepository;

    @Autowired
    public ProfessionService(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    public List<ProfessionEntity> findAllProfession(){
        return professionRepository.findAll();
    }

    public ProfessionEntity findOneProfession(Long id){
        return professionRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(ProfessionEntity professionEntity){
        professionRepository.save(professionEntity);
    }

    @Transactional
    public void update(Long id, ProfessionEntity updateProfession){
        updateProfession.setId(id);
        professionRepository.save(updateProfession);
    }
    @Transactional
    public void delete(Long id){
        professionRepository.deleteById(id);
    }

}
