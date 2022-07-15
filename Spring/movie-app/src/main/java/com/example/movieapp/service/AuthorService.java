package com.example.movieapp.service;

import com.example.movieapp.mapper.Author.AuthorDto;

import java.util.List;

public interface AuthorService {
    /**
     * Return all authors from DB
     * @return List<AuthorID></AuthorID>
     */
    List<AuthorDto> findAllAuthors();

    /**
     * Returns the author with the matching id from DB
     * @param id of the author to return
     * @return the authorDTO
     */
    AuthorDto findById(Long id);

    /**
     * Returns the new author object from the DB
     * @param dto author to create
     * @return the created authorDTO
     */
    AuthorDto create(AuthorDto dto);

    /**
     * Returns the updated author object from the DB
     * @param dto updated author
     * @return the updated authorDTO
     */
    AuthorDto update(AuthorDto dto);

    /**
     * Deletes the author object from the DB
     * @param id of the selected author
     */
    void delete(Long id);
}
