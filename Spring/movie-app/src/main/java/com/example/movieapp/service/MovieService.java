package com.example.movieapp.service;

import com.example.movieapp.mapper.Movie.MovieDTO;
import com.example.movieapp.model.MovieEntity;

import java.util.List;

public interface MovieService {

    /**
     * Returns all movies from DB
     * @return List<MovieEntity>
     */
    List<MovieDTO> findAllMovies();

    /**
     * Returns the new object from the DB
     * @return movieDTO
     */
    MovieDTO create(MovieDTO dto);
}
