package com.luxoft.spingsecurity.dto;

import lombok.Value;

@Value(staticConstructor = "OrderDto")
public class OrderDto {
    long id;
    double amount;
}
