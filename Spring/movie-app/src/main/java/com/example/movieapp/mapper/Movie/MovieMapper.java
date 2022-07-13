package com.example.movieapp.mapper.Movie;

import com.example.movieapp.model.MovieEntity;

import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {

    public MovieMapper(){}

    public MovieDTO toDTO(MovieEntity movieEntity) {

        MovieDTO dto = new MovieDTO();

        dto.setId(movieEntity.getId());
        dto.setTitle(movieEntity.getTitle());
        dto.setAuthor(movieEntity.getAuthor());

        return dto;
    }

    public List<MovieDTO> toDtoList(List<MovieEntity> movieEntityList) {
        return movieEntityList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
