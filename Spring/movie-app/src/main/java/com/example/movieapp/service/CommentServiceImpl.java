package com.example.movieapp.service;

import com.example.movieapp.mapper.Comment.CommentMapper;
import com.example.movieapp.mapper.Comment.CommentDto;
import com.example.movieapp.mapper.Comment.CreateCommentDto;
import com.example.movieapp.model.CommentEntity;
import com.example.movieapp.model.MovieEntity;
import com.example.movieapp.model.UserEntity;
import com.example.movieapp.repository.CommentRepository;
import com.example.movieapp.repository.MovieRepository;
import com.example.movieapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final CommentMapper commentMapper = new CommentMapper();

    @Override
    public List<CommentDto> findAllComments() {
        return commentMapper.toDtoList(commentRepository.findAll());
    }

    @Override
    public CommentDto findById(Long id) {
        return commentMapper.toDto(commentRepository.getReferenceById(id));
    }

    @Override
    public CommentDto create(CreateCommentDto dto) {

        CommentEntity comment = new CommentEntity();

        comment.setId(dto.getId());
        comment.setComment(dto.getComment());
        comment.setDate(dto.getDate());

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUserId());
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(dto.getMovieId());

        if(userEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("User wasn't found with the provided ID");
        }
        if(movieEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Movie wasn't found with the provided ID");
        }

        comment.setUserEntity(userEntityOptional.get());
        comment.setMovieEntity(movieEntityOptional.get());

        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public CommentDto update(CommentDto dto) {
        CommentEntity comment = new CommentEntity();

        comment.setId(dto.getId());
        comment.setComment(dto.getComment());
        comment.setDate(dto.getDate());

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getId());
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(dto.getId());

        if(userEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("User wasn't found with the provided ID");
        }
        if(movieEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Movie wasn't found with the provided ID");
        }

        comment.setUserEntity(userEntityOptional.get());
        comment.setMovieEntity(movieEntityOptional.get());

        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            throw new ServiceException("ID can't be null");
        }

        Optional<CommentEntity> commentEntityOptional = commentRepository.findById(id);

        if(commentEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Comment with the provided id wasn't found");
        }

        CommentEntity commentEntity = commentEntityOptional.get();

        commentRepository.delete(commentEntity);
    }
}
