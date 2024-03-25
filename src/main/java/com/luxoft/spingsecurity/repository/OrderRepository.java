package com.luxoft.spingsecurity.repository;

import com.luxoft.spingsecurity.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
