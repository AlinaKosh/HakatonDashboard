package com.cbr.testTask.controllers;

import com.cbr.testTask.dtos.CurrencyDto;
import com.cbr.testTask.services.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}/v1")
public class CurrencyController {
    public final CurrencyRateService currencyRateService;

    @PostMapping("/currencyRate")
    @ResponseBody
    public CurrencyDto getCurrencyRate(String currency, LocalDate date) {
        return currencyRateService.getCurrencyRate(currency, date);
    }

    @GetMapping("/getAll/{pageSize}/{pageNum}")
    public Page<CurrencyDto> getAllCurrencyDtosWithPagination(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        return currencyRateService.getAllCurrencyDtosWithPagination(pageNum, pageSize);
    }
}