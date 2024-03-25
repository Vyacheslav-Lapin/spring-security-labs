package com.luxoft.spingsecurity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    long id;
    String login;
    String password;
    List<String> roles;
}
