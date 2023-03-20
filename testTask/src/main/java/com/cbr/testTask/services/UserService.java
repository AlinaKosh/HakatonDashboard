package com.cbr.testTask.services;

import com.cbr.testTask.db.CandidatesEntity;
import com.cbr.testTask.db.UsersEntity;
import com.cbr.testTask.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository candidateRepositories) {
        this.userRepository = candidateRepositories;
    }

    public List<UsersEntity> findAll(){
        return userRepository.findAll();
    }
    public UsersEntity findOne(long id){
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(UsersEntity person){
        userRepository.save(person);
    }

    @Transactional
    public void update(Long id, UsersEntity updatePerson){
        updatePerson.setId(id);
        userRepository.save(updatePerson);
    }

    @Transactional
    public void delete(long id){
        userRepository.deleteById(id);
    }

    public Optional<UsersEntity> getPersonByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<CandidatesEntity> getChosen(long id){
        return Objects.requireNonNull(userRepository.findById(id).orElse(null)).getChosenCandidates();
    }


}
