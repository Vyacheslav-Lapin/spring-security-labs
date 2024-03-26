package com.luxoft.spingsecurity.dto.converters;

import com.luxoft.spingsecurity.dto.CompanyDto;
import com.luxoft.spingsecurity.model.Company;

import org.springframework.stereotype.Component;

import static com.luxoft.spingsecurity.dto.CompanyDto.*;
import static com.luxoft.spingsecurity.model.Company.*;

@Component
public class CompanyDtoConverter {

    public CompanyDto toDto(Company domain) {
        return CompanyDto(domain.getId(), domain.getName());
    }

    public Company toDomain(CompanyDto dto) {
        return Company(dto.getName())
                   .setId(dto.getId());
    }

    public Company toDomain(CompanyDto dto, Company original) {
        return original.setName(dto.getName());
    }
}
