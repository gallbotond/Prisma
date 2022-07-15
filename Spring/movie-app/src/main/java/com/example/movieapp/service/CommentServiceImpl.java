package com.example.movieapp.service;

import com.example.movieapp.mapper.Comment.CommentDto;
import com.example.movieapp.mapper.Comment.CommentMapper;
import com.example.movieapp.repository.CommentRepository;
import com.example.movieapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper = new CommentMapper();

    @Override
    public List<CommentDto> findAllComment() {
        return commentMapper;
    }

    @Override
    public CommentDto findById(Long id) {
        return null;
    }

    @Override
    public CommentDto create(CommentDto dto) {
        return null;
    }

    @Override
    public CommentDto update(CommentDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
