package com.cbr.testTask.repo;

import com.cbr.testTask.db.SkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity, Long> {
}
