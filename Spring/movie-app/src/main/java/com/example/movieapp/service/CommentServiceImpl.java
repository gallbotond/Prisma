package com.example.movieapp.service;

import com.example.movieapp.mapper.Comment.CommentDto;
import com.example.movieapp.mapper.Comment.CommentMapper;
import com.example.movieapp.model.CommentEntity;
import com.example.movieapp.model.MovieEntity;
import com.example.movieapp.model.UserEntity;
import com.example.movieapp.repository.CommentRepository;
import com.example.movieapp.repository.MovieRepository;
import com.example.movieapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;
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
    public CommentDto create(CommentDto dto) {
        return getCommentDto(dto);
    }

    @Override
    public CommentDto update(CommentDto dto) {
        return getCommentDto(dto);
    }

    private CommentDto getCommentDto(CommentDto dto) {
        if(dto.getComment().isEmpty()) {
            throw new ServiceException("Comment field can't be blank");
        }

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUserDto().getId());
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(dto.getMovieDto().getId());

        if(userEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("User wasn't found with the provided ID");
        }
        if(movieEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Movie wasn't found with the provided ID");
        }

        CommentEntity commentEntity = commentMapper.toEntity(dto);
        CommentEntity newComment = commentRepository.save(commentEntity);

        return commentMapper.toDto(newComment);
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
