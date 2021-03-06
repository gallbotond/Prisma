package com.example.movieapp.mapper.Movie;

import com.example.movieapp.mapper.Author.AuthorMapper;
import com.example.movieapp.model.MovieEntity;
import com.example.movieapp.model.UserEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class MovieMapper {

    private final AuthorMapper authorMapper = new AuthorMapper();

    public MovieDto toDto(MovieEntity movieEntity) {

        MovieDto dto = new MovieDto();

        dto.setId(movieEntity.getId());
        dto.setTitle(movieEntity.getTitle());
        dto.setDuration(movieEntity.getDuration());
        dto.setGenre(movieEntity.getGenre());
        dto.setAuthorDto(authorMapper.toDTO(movieEntity.getAuthor()));

        return dto;
    }

    public List<MovieDto> toDtoList(List<MovieEntity> movieEntityList) {
        return movieEntityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public MovieEntity toEntity(MovieDto dto) {

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setId(dto.getId());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setDuration(dto.getDuration());
        movieEntity.setGenre(dto.getGenre());
        movieEntity.setAuthor(authorMapper.toEntity(dto.getAuthorDto()));

        return movieEntity;
    }

    public List<MovieEntity> toEntityList(List<MovieDto> movieDtos) {
        return movieDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
