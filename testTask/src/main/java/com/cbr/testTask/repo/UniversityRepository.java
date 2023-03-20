package com.cbr.testTask.repo;

import com.cbr.testTask.db.UniversitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<UniversitiesEntity, Long> {
}
