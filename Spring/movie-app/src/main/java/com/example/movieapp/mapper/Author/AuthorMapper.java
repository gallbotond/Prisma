package com.example.movieapp.mapper.Author;

import com.example.movieapp.model.AuthorEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {

    public AuthorMapper(){}

    public AuthorDto toDTO(AuthorEntity authorEntity) {

        AuthorDto dto = new AuthorDto();

        dto.setId(authorEntity.getId());
        dto.setName(authorEntity.getName());
        dto.setBirthday(authorEntity.getBirthday());

        return dto;
    }

    public List<AuthorDto> toDtoList(List<AuthorEntity> authorList) {
        return authorList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public AuthorEntity toEntity(AuthorDto dto) {
        AuthorEntity author = new AuthorEntity();

        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setBirthday(dto.getBirthday());

        return author;
    }
}
