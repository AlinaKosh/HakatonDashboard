package com.cbr.testTask.repo;

import com.cbr.testTask.db.CandidatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<CandidatesEntity, Long>{

   /* @Query("select c from CandidatesEntity c join CandidateToAdditionalCompetitionEntity on CandidatesEntity.id = CandidateToAdditionalCompetitionEntity.candidateId where CandidateToAdditionalCompetitionEntity.additionalId = ?1 ")
    Optional<CandidatesEntity> findByCompetition(long id); */
}
