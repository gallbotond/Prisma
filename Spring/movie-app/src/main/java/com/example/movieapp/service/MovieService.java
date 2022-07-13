package com.example.movieapp.service;

import com.example.movieapp.mapper.Movie.MovieDTO;

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

    /**
     * Returns the updated movie from the DB
     * @param dto updated movie
     * @return movieDTO
     */
    MovieDTO update(MovieDTO dto);
}
