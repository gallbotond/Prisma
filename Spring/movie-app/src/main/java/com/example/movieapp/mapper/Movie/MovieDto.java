package com.example.movieapp.mapper.Movie;

import com.example.movieapp.mapper.Author.AuthorDto;

public class MovieDto {
    Long id;
    String title;
    String duration;
    String genre;
    AuthorDto authorDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public AuthorDto getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDto authorDTO) {
        this.authorDTO = authorDTO;
    }
}
