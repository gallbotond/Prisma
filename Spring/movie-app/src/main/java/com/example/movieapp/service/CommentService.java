package com.example.movieapp.service;

import com.example.movieapp.mapper.Comment.CommentDto;

import java.util.List;

public interface CommentService {
    /**
     * Returns all comments from DB
     * @return List<CommentDto>
     */
    List<CommentDto> findAllComments();

    /**
     * Returns the comment with the provided id from DB
     * @param id of the comment to return
     * @return the CommentDto
     */
    CommentDto findById(Long id);

    /**
     * Returns the created comment from the DB
     * @param dto comment to create
     * @return the created CommentDto
     */
    CommentDto create(CommentDto dto);

    /**
     * Returns the updated comment from the DB
     * @param dto updated comment
     * @return the updated CommentDto
     */
    CommentDto update(CommentDto dto);

    /**
     * Deleted the comment with the matching id from DB
     * @param id of the comment to delete
     */
    void delete(Long id);
}
