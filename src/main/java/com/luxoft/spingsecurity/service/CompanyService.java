package com.luxoft.spingsecurity.service;

import java.util.List;

import com.luxoft.spingsecurity.dto.CompanyDto;
import com.luxoft.spingsecurity.dto.OrderDto;
import com.luxoft.spingsecurity.dto.converters.CompanyDtoConverter;
import com.luxoft.spingsecurity.dto.converters.OrderDtoConverter;
import com.luxoft.spingsecurity.repository.CompanyRepository;
import com.luxoft.spingsecurity.repository.OrderRepository;
import com.luxoft.spingsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class CompanyService {

    CompanyRepository companyRepository;
    UserRepository userRepository;
    OrderRepository orderRepository;

    CompanyDtoConverter companyDtoConverter;
    OrderDtoConverter orderDtoConverter;

    @Transactional(readOnly = true)
    public List<CompanyDto> getAll() {
        return companyRepository.findAll().stream()
            .map(companyDtoConverter::toDto)
            .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<CompanyDto> getAllByUserId(long userId) {
        val user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
        return user.getCompanies().stream()
            .map(companyDtoConverter::toDto)
            .collect(toList());
    }

    @Transactional(readOnly = true)
    public CompanyDto getById(long companyId) {
        return companyRepository.findById(companyId)
            .map(companyDtoConverter::toDto)
            .orElseThrow(() -> new IllegalArgumentException("Company does not exist"));
    }

    @Transactional
    public CompanyDto createCompany(CompanyDto newCompany, long userId) {
        val user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
        val company = companyDtoConverter.toDomain(newCompany);
        val withId = companyRepository.save(company);
        user.getCompanies().add(company);
        userRepository.save(user);
        return companyDtoConverter.toDto(withId);
    }

    @Transactional
    public CompanyDto updateCompany(CompanyDto companyDto) {
        val company = companyRepository.findById(companyDto.getId())
            .orElseThrow(() -> new IllegalArgumentException("Company does not exist"));
        val updated = companyDtoConverter.toDomain(companyDto, company);
        val fromDb = companyRepository.save(updated);
        return companyDtoConverter.toDto(fromDb);
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getCompanyOrders(long companyId) {
        val company = companyRepository.findById(companyId)
            .orElseThrow(() -> new IllegalArgumentException("Company does not exist"));
        return company.getOrders().stream()
            .map(orderDtoConverter::toDto)
            .collect(toList());
    }

    @Transactional
    public OrderDto createOrder(long companyId, OrderDto orderDto) {
        val company = companyRepository.findById(companyId)
            .orElseThrow(() -> new IllegalArgumentException("Company does not exist"));
        val order = orderDtoConverter.toDomain(orderDto, company);
        val withId = orderRepository.save(order);
        return orderDtoConverter.toDto(withId);
    }

    @Transactional
    public void deleteOrder(
        @SuppressWarnings("unused") // Yes, companyId is not used now
        long companyId,
        long orderId) {
        orderRepository.deleteById(orderId);
    }
}
