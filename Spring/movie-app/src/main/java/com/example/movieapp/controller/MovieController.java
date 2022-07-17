package com.example.movieapp.controller;

import com.example.movieapp.mapper.Movie.MovieDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovie(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(movieService.findById(id));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMovie(@RequestBody MovieDto movieDto) {
        try {
            return ResponseEntity.ok().body(movieService.create(movieDto));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMovie(@RequestBody MovieDto movieDto) {
        try {
            return ResponseEntity.ok().body(movieService.update(movieDto));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        try {
            movieService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
