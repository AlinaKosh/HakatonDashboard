package com.cbr.testTask.converters;

import com.cbr.testTask.db.CurrencyEntity;
import com.cbr.testTask.dtos.CurrencyDto;
import org.springframework.beans.BeanUtils;

public class CurrencyConverter {
    public static CurrencyDto toDto(CurrencyEntity entity){
        CurrencyDto dto = new CurrencyDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static CurrencyEntity toEntity(CurrencyDto dto){
        CurrencyEntity entity = new CurrencyEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
