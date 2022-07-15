package com.example.movieapp.service;

import com.example.movieapp.mapper.Movie.MovieDto;

import java.util.List;

public interface MovieService {

    /**
     * Returns all movies from DB
     * @return List<MovieDto>
     */
    List<MovieDto> findAllMovies();

    /**
     * Returns the movie with the matching id from DB
     * @param id of the movie to return
     * @return the movieDTO
     */
    MovieDto findById(Long id);

    /**
     * Returns the new movie object from the DB
     * @param dto movie to create
     * @return the created movieDTO
     */
    MovieDto create(MovieDto dto);

    /**
     * Returns the updated movie from the DB
     * @param dto updated movie
     * @return the updated movieDTO
     */
    MovieDto update(MovieDto dto);

    /**
     * Deletes the Movie Object from DB
     * @param id of the selected Movie
     */
    void delete(Long id);
}
