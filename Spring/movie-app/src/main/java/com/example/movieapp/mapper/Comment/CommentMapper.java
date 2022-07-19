package com.example.movieapp.mapper.Comment;

import com.example.movieapp.mapper.Movie.MovieMapper;
import com.example.movieapp.mapper.User.UserMapper;
import com.example.movieapp.model.CommentEntity;
import com.example.movieapp.service.MovieService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CommentMapper {

    private final UserMapper userMapper = new UserMapper();
    private final MovieMapper movieMapper = new MovieMapper();

    public CommentDto toDto(CommentEntity commentEntity) {
        CommentDto dto = new CommentDto();
        
        dto.setId(commentEntity.getId());
        dto.setComment(commentEntity.getComment());
        dto.setDate(commentEntity.getDate());
        dto.setUserDto(userMapper.toDto(commentEntity.getUserEntity()));
        dto.setMovieDto(movieMapper.toDto(commentEntity.getMovieEntity()));

        return dto;
    }

    public List<CommentDto> toDtoList(List<CommentEntity> commentEntityList) {
        return commentEntityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
