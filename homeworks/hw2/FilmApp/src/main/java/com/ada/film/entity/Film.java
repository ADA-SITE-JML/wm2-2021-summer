package com.ada.film.entity;


import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.time.Year;
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
    private String title;

    @Column(name="CATEGORY")
    private String film_category;

    @Column(name="LANGUAGE",columnDefinition = "varchar(64) default 'Azerbaijani'")
    private String language;

    @Column(name="RELEASE_YEAR", columnDefinition = "date check(RELEASE_YEAR<=now())")
    private Date release_year;

    @Column(name = "DURATION")
    private String film_duration;


    @ManyToMany
    @JoinTable(
            name = "FILMS_ACTORS",
            joinColumns = @JoinColumn(name="FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID")
    )
    private Set<Actor> actors;


    public String getTitle() {
        return title;
    }

    public int getFilm_id() {
        return film_id;
    }

    public Date getRelease_year() {
        return release_year;
    }

    public String getFilm_duration() {
        return film_duration;
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

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRelease_year(Date release_year) {
        this.release_year = release_year;
    }

    public void setFilm_duration(String film_duration) {
        this.film_duration = film_duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Film(){

    }

    public String toString(){
        return this.title;
    }


}
