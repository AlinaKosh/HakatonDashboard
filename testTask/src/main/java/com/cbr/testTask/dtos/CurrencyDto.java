package com.cbr.testTask.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CurrencyDto {
    @JsonIgnore
    private Long id;
    private double exchangeRates;
    private LocalDate dateOfRequest;
    private String currency;
}
