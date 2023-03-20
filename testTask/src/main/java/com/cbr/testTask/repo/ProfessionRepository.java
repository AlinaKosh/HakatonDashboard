package com.cbr.testTask.repo;

import com.cbr.testTask.db.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Long> {
}
