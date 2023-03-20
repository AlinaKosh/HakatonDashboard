package com.cbr.testTask.repo;

import com.cbr.testTask.db.CurrencyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;


public interface CurrencyRepo extends JpaRepository<CurrencyEntity, String> {
    Page<CurrencyEntity> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(e) > 0 FROM currency e WHERE e.date_of_request = :local_date AND e.currency = :local_currency", nativeQuery = true)
    boolean existsCurrencyLikeCustomQuery(@Param("local_date") LocalDate local_date, @Param("local_currency") String currency);
}
