package com.cbr.testTask.repo;

import com.cbr.testTask.db.ChosenCandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChosenCandidateRepository extends JpaRepository<ChosenCandidateEntity, Long> {
}
