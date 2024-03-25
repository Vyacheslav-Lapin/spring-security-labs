package com.luxoft.spingsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderDto {
    long id;
    double amount;
}
