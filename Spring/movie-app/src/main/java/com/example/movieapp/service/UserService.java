package com.example.movieapp.service;

import com.example.movieapp.mapper.User.UserDto;

import java.util.List;

public interface UserService {
    /**
     * Returns all users fron DB
     * @return List<UserDto>
     */
    List<UserDto> findAllUsers();

    /**
     * Returns the user with the provided id from DB
     * @param id of the user to return
     * @return the userDto
     */
    UserDto findById(Long id);

    /**
     * Returns the created user object from the DB
     * @param dto user to create
     * @return the created userDto
     */
    UserDto create(UserDto dto);

    /**
     * Returns the updated user object from the DB
     * @param dto the updated user
     * @return the updated userDto
     */
    UserDto update(UserDto dto);

    /**
     * Deletes the user with the provided id
     * @param id of the user to delete
     */
    void delete(Long id);
}
