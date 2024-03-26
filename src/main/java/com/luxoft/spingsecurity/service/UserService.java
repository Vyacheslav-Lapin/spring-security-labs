package com.luxoft.spingsecurity.service;

import java.util.List;

import com.luxoft.spingsecurity.dto.UserDto;
import com.luxoft.spingsecurity.dto.converters.UserDtoConverter;
import com.luxoft.spingsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;
    UserDtoConverter userDtoConverter;

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
            .map(userDtoConverter::toDto)
            .collect(toList());
    }

    @Transactional(readOnly = true)
    public UserDto getById(long userId) {
        return userRepository.findById(userId)
            .map(userDtoConverter::toDto)
            .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
    }

    @Transactional
    public UserDto create(UserDto userDto) {
        val user = userDtoConverter.toDomain(userDto);
        val withId = userRepository.save(user);
        return userDtoConverter.toDto(withId);
    }

    @Transactional
    public UserDto update(UserDto userDto) {
        val user = userRepository.findById(userDto.getId())
            .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
        val updated = userDtoConverter.toDomain(userDto, user);
        val fromDb = userRepository.save(updated);
        return userDtoConverter.toDto(fromDb);
    }
}
