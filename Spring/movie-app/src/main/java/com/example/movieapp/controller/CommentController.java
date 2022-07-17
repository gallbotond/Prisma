package com.example.movieapp.controller;

import com.example.movieapp.mapper.Comment.CommentDto;
import com.example.movieapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
@CrossOrigin
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllComments() {
        try {
            return ResponseEntity.ok().body(commentService.findAllComments());
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getComment(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(commentService.findById(id));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createComment(@RequestBody CommentDto dto) {
        try {
            return ResponseEntity.ok().body(commentService.create(dto));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateComment(@RequestBody CommentDto dto) {
        try {
            return ResponseEntity.ok().body(commentService.create(dto));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        try {
            commentService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
