package com.example.movieapp.controller;

import com.example.movieapp.mapper.Movie.MovieDTO;
import com.example.movieapp.service.MovieService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
@CrossOrigin
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllMovies() {
        try {
            return ResponseEntity.ok().body(movieService.findAllMovies());
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMovie(@RequestBody MovieDTO movieDTO) {
        try {
            return ResponseEntity.ok().body(movieService.create(movieDTO));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/put")
    public ResponseEntity<?> updateMovie(@RequestBody MovieDTO movieDTO) {
        try {
            return ResponseEntity.ok().body(movieService.update(movieDTO));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
