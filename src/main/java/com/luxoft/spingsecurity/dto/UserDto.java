package com.luxoft.spingsecurity.dto;

import java.util.List;

import lombok.Value;

@Value(staticConstructor = "UserDto")
public class UserDto {
    long id;
    String login;
    String password;
    List<String> roles;
}
