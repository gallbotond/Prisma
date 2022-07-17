package com.example.movieapp.service;

import com.example.movieapp.mapper.Author.AuthorDto;
import com.example.movieapp.mapper.Author.AuthorMapper;
import com.example.movieapp.model.AuthorEntity;
import com.example.movieapp.repository.AuthorRepository;
import com.example.movieapp.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper = new AuthorMapper();

    @Override
    public List<AuthorDto> findAllAuthors() {
        return authorMapper.toDtoList(authorRepository.findAll());
    }

    @Override
    public AuthorDto findById(Long id) {
        return authorMapper.toDTO(authorRepository.getReferenceById(id));
    }

    @Override
    public AuthorDto create(AuthorDto dto) {
        if(dto.getName().isEmpty()) {
            throw new ServiceException("Author name can't be blank");
        }

        AuthorEntity author = authorMapper.toEntity(dto);
        AuthorEntity newAuthor = authorRepository.save(author);

        return authorMapper.toDTO(newAuthor);
    }

    @Override
    public AuthorDto update(AuthorDto dto) {

        if(dto.getName().isEmpty()) {
            throw new ServiceException("Fields can't be blank");
        }

        if(dto.getId() == null) {
            throw new IllegalArgumentException("Invalid ID");
        }

        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(dto.getId());

        if (authorEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Object with the provided id was not found");
        }

        AuthorEntity updatedAuthorEntity = authorMapper.toEntity(dto);
        AuthorEntity newAuthor = authorRepository.save(updatedAuthorEntity);

        return authorMapper.toDTO(newAuthor);
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            throw new ServiceException("ID can't be null");
        }

        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(id);

        if(authorEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with the provided id wasn't found");
        }

        AuthorEntity author = authorEntityOptional.get();

        authorRepository.delete(author);
    }
}
