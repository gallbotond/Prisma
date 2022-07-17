package com.example.movieapp.mapper.User;

import com.example.movieapp.model.UserEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserMapper {

    public UserDto toDto(UserEntity user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setDate(user.getDate());
        dto.setBio(user.getBio());

        return dto;
    }

    public List<UserDto> toDtoList(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserEntity toEntity(UserDto userDto) {
        UserEntity entity = new UserEntity();

        entity.setBio(userDto.getBio());
        entity.setDate(userDto.getDate());
        entity.setUsername(userDto.getUsername());
        entity.setId(userDto.getId());

        return entity;
    }
}
