package com.example.movieapp.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private String date;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "FK_USER_ID")
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "FK_MOVIE_ID")
    private MovieEntity movieEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }
}
