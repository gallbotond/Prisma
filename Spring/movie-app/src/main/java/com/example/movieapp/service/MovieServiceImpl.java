package com.example.movieapp.service;

import com.example.movieapp.mapper.Movie.MovieDto;
import com.example.movieapp.mapper.Movie.MovieMapper;
import com.example.movieapp.model.AuthorEntity;
import com.example.movieapp.model.MovieEntity;
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
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final AuthorRepository authorRepository;
    private final MovieMapper movieMapper = new MovieMapper();

    @Override
    public List<MovieDto> findAllMovies() {
        return movieMapper.toDtoList(movieRepository.findAll());
    }

    @Override
    public MovieDto findById(Long id) {
        return movieMapper.toDTO(movieRepository.getReferenceById(id));
    }

    @Override
    public MovieDto create(MovieDto dto) {
        if(dto.getTitle().isEmpty()) {
            throw new ServiceException("Movie title can't be blank");
        }

        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(dto.getAuthorDto().getId());

        if(authorEntityOptional.isEmpty())
            throw new EntityNotFoundException("Author wasn't found with the provided id");

        MovieEntity movieEntity = movieMapper.toEntity(dto);
        MovieEntity newMovie = movieRepository.save(movieEntity);

        return movieMapper.toDTO(newMovie);
    }

    @Override
    public MovieDto update(MovieDto dto) {
        if(dto.getTitle().isEmpty()) {
            throw new ServiceException("Fields can't be blank");
        }

        if(dto.getId() == null) {
            throw new IllegalArgumentException("Invalid ID");
        }

        Optional<MovieEntity> movieOptional = movieRepository.findById(dto.getId());
        if(movieOptional.isEmpty()) {
            throw new EntityNotFoundException("Object with the provided id was not found");
        }

        MovieEntity updatedEntity = movieMapper.toEntity(dto);
        MovieEntity newMovie = movieRepository.save(updatedEntity);

        return movieMapper.toDTO(newMovie);
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            throw new ServiceException("ID can't be null");
        }

        Optional<MovieEntity> movieOptional = movieRepository.findById(id);

        if(movieOptional.isEmpty()) {
            throw new EntityNotFoundException("Movie with the provided id was not found");
        }

        MovieEntity movieEntity = movieOptional.get();

        movieRepository.delete(movieEntity);
    }
}
