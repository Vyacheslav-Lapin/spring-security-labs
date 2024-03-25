package com.luxoft.spingsecurity.dto.converters;

import com.luxoft.spingsecurity.dto.UserDto;
import com.luxoft.spingsecurity.model.User;

import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

  public UserDto toDto(User domain) {
    return new UserDto(domain.getId(), domain.getLogin(), null, domain.getRoles());
  }

  public User toDomain(UserDto dto) {
    return new User()
               .setId(dto.getId())
               .setLogin(dto.getLogin())
               .setPassword(dto.getPassword())
               .setRoles(dto.getRoles());
  }

  public User toDomain(UserDto dto, User original) {
    return original
               .setLogin(dto.getLogin())
               .setPassword(dto.getPassword())
               .setRoles(dto.getRoles());
  }
}
