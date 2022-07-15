package com.example.movieapp.controller;

import com.example.movieapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    }
}
