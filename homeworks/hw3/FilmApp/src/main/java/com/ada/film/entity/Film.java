package com.ada.film.entity;


import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="FILMS")
public class Film {

    @Id
    @Column(name = "FILM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    @Column(name = "TITLE", length = 128)
    @NotNull
    @Size(min = 3, max = 30, message = "Please enter a \"TITLE\" with the length between 3 and 30!")
    private String title;

    @Column(name="PRODUCER")
    @Size(min = 3, max = 20, message = "Please enter a \"PRODUCER\" with the length between 3 and 20!")
    private String producer;

    @Column(name="CATEGORY")
    @Size(min = 3, max = 20, message = "Please enter a \"CATEGORY\" with the length between 3 and 20!")
    private String film_category;

    @Column(name="LANGUAGE",columnDefinition = "varchar(64) default 'Azerbaijani'")
    @Size(min = 2, max = 20, message = "Please enter a \"LANGUAGE\" with the length between 2 and 20!")
    private String language;

    @Column(name="RELEASE_DATE", columnDefinition = "date check(RELEASE_DATE<=now())")
    private Date release_date;

    @Column(name = "DURATION")
    private int film_duration;


    @ManyToMany()
    @JoinTable(
            name = "FILMS_ACTORS",
            joinColumns = @JoinColumn(name="FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Actor> actors;


    public String getTitle() {
        return title;
    }

    public int getFilm_id() {
        return film_id;
    }

    public String getProducer() { return producer; }

    public Date getRelease_date() {
        return release_date;
    }


    public String getFilm_category() {
        return film_category;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public String getLanguage() {
        return language;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setFilm_category(String film_category) {
        this.film_category = film_category;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return this.title;
    }

    public int getFilm_duration() {
        return film_duration;
    }

    public void setFilm_duration(int film_duration) {
        this.film_duration = film_duration;
    }
}
