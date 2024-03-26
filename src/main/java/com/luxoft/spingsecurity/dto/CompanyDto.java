package com.luxoft.spingsecurity.dto;

import lombok.Value;

@Value(staticConstructor = "CompanyDto")
public class CompanyDto {
    long id;
    String name;
}
