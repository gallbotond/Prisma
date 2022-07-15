package com.example.movieapp.model;

import javax.persistence.*;

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
    private UserEntity user;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "FK_MOVIE_ID")
    private MovieEntity movie;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }
}
