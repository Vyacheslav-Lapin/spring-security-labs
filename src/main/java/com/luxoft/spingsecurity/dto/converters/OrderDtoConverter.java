package com.luxoft.spingsecurity.dto.converters;

import com.luxoft.spingsecurity.dto.OrderDto;
import com.luxoft.spingsecurity.model.Company;
import com.luxoft.spingsecurity.model.Order;

import org.springframework.stereotype.Component;

import static com.luxoft.spingsecurity.dto.OrderDto.*;
import static com.luxoft.spingsecurity.model.Order.*;

@Component
public class OrderDtoConverter {

    public OrderDto toDto(Order domain) {
        return OrderDto(domain.getId(), domain.getAmount());
    }

    public Order toDomain(OrderDto dto, Company customer) {
        return Order(dto.getAmount())
                   .setId(dto.getId())
                   .setCustomer(customer);
    }
}
