package com.example.movieapp.controller;

import com.example.movieapp.mapper.User.UserDto;
import com.example.movieapp.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {

    @GetMapping("/health-check")
    public ResponseEntity<?> healthCheck(){
        return ResponseEntity.ok().build();
    }

    private final UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok().body(userService.findAllUsers());
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(userService.findById(id));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok().body(userService.create(userDto));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok().body(userService.update(userDto));
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}