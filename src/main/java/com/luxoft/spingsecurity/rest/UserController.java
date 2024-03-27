package com.luxoft.spingsecurity.rest;

import java.util.List;

import com.luxoft.spingsecurity.dto.UserDto;
import com.luxoft.spingsecurity.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("/user")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{userId}")
    public UserDto getById(@PathVariable long userId) {
        return userService.getById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/user")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }
}
