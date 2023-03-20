package com.cbr.testTask.parser;

import com.cbr.testTask.dtos.CurrencyDto;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyParser {

    List<CurrencyDto> parse(String ratesAsString, LocalDate date);
}
