package com.example.movieapp.service;

import com.example.movieapp.mapper.Movie.MovieDTO;
import com.example.movieapp.mapper.Movie.MovieMapper;
import com.example.movieapp.model.MovieEntity;
import com.example.movieapp.repository.MovieRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.rmi.server.ServerCloneException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private MovieMapper movieMapper = new MovieMapper();

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> findAllMovies() {
        return movieMapper.toDtoList(movieRepository.findAll());
    }

    @Override
    public MovieDTO create(MovieDTO dto) {
        if(dto.getTitle().isEmpty()) {
            throw new ServiceException("Movie title can't be blank");
        }

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setAuthor(dto.getAuthor());
        movieEntity.setId(dto.getId());

        MovieEntity newMovie = movieRepository.save(movieEntity);

        return movieMapper.toDTO(newMovie);
    }
}
