package com.cbr.testTask.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "currency")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyEntity extends BaseEntity {
    @Column(name = "ExchangeRates")
    private double exchangeRates;

    @Column(name = "DateOfRequest")
    private LocalDate dateOfRequest;

    @Column(name = "Currency")
    private String currency;
}
