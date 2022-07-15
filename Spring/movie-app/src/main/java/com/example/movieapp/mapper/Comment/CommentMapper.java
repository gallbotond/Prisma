package com.example.movieapp.mapper.Comment;

import com.example.movieapp.mapper.Movie.MovieMapper;
import com.example.movieapp.mapper.User.UserMapper;
import com.example.movieapp.model.CommentEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentMapper {

    private final UserMapper userMapper = new UserMapper();
    private final MovieMapper movieMapper = new MovieMapper();

    public CommentDto toDto(CommentEntity commentEntity) {
        CommentDto dto = new CommentDto();
        
        dto.setId(commentEntity.getId());
        dto.setComment(commentEntity.getComment());
        dto.setDate(commentEntity.getDate());
        dto.setUserDto(userMapper.toDto(commentEntity.getUser()));
        dto.setMovieDto(movieMapper.toDTO(commentEntity.getMovie()));

        return dto;
    }
}
