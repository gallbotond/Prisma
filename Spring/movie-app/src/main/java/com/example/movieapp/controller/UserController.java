package com.example.movieapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @GetMapping("/health-check")
    public ResponseEntity<?> healthCheck(){
        return ResponseEntity.ok().build();
    }
}