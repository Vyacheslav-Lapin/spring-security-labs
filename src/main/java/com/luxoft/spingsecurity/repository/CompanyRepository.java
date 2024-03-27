package com.luxoft.spingsecurity.repository;

import com.luxoft.spingsecurity.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
