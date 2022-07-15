package com.example.movieapp.controller;

import com.example.movieapp.mapper.Author.AuthorDto;
import com.example.movieapp.service.AuthorService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
@CrossOrigin
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllAuthors() {
        try {
            return ResponseEntity.ok().body(authorService.findAllAuthors());
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable("id") Long id) {
        try{
            return ResponseEntity.ok().body(authorService.findById(id));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDto authorDTO) {
        try {
            return ResponseEntity.ok().body(authorService.create(authorDTO));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAuthor(@RequestBody AuthorDto authorDTO) {
        try {
            return ResponseEntity.ok().body(authorService.update(authorDTO));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {
        try {
            authorService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
