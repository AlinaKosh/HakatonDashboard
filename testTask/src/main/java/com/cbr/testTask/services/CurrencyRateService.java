package com.cbr.testTask.services;

import com.cbr.testTask.config.CbrConfig;
import com.cbr.testTask.converters.CurrencyConverter;
import com.cbr.testTask.dtos.CurrencyDto;
import com.cbr.testTask.exceptions.CurrencyNotFoundException;
import com.cbr.testTask.parser.CurrencyParser;
import com.cbr.testTask.repo.CurrencyRepo;
import com.cbr.testTask.requester.CbrRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyRateService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final CbrRequest cbrRequest;
    private final CurrencyParser currencyParser;
    private final CbrConfig cbrConfig;
    private final CurrencyRepo repo;

    public CurrencyDto getCurrencyRate(String currency, LocalDate date) {

        String urlWithParams = String.format("%s?date_req=%s", cbrConfig.getUrl(), DATE_FORMATTER.format(date));
        String ratesAsXml = cbrRequest.getRatesAsXml(urlWithParams);
        List<CurrencyDto> rates = currencyParser.parse(ratesAsXml, date);

        CurrencyDto a = rates.stream().filter(rate -> currency.equals(rate.getCurrency()))
                .findFirst()
                .orElseThrow(() -> new CurrencyNotFoundException("Currency Rate not found. Currency:" + currency + ", date:" + date));

        if(repo.existsCurrencyLikeCustomQuery(a.getDateOfRequest(), a.getCurrency())) {
            return a;
        }
        else {
            return CurrencyConverter.toDto(repo.save(CurrencyConverter.toEntity(a)));
        }
    }

    public Page<CurrencyDto> getAllCurrencyDtosWithPagination(Integer pageNum, Integer pageSize) {
        return new PageImpl<>(repo.findAll(PageRequest.of(pageNum, pageSize)).stream().map(CurrencyConverter::toDto).collect(Collectors.toList()));
    }
}
