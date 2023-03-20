package com.cbr.testTask.repo;

import com.cbr.testTask.db.AdditionalCompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalCompetitionRepository extends JpaRepository<AdditionalCompetitionEntity, Long> {

}
