package com.luxoft.spingsecurity.repository;

import com.luxoft.spingsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
