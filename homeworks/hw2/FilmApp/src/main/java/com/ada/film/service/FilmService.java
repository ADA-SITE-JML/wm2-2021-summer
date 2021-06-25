package com.ada.film.service;

import com.ada.film.entity.Film;
import com.ada.film.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public List<Film> getAllFilms(){
        List<Film> films = (List<Film>) filmRepository.findAll();
        return films;
    }

    public Film getFilmById(Integer id){
        Optional<Film> f = filmRepository.findById(id);
        if (f.isPresent()){
            return f.get();
        }
        return new Film();
    }

    public Film saveFilm(Film f){
        Film result_film = filmRepository.save(f);
        return result_film;
    }

    public List<Film> getFilmsByCategory(String category){
        List<Film> films = (List<Film>) filmRepository.getFilmsByCategory(category);
        return films;
    }

    public List<Film> getFilmsByCount(Integer count){
        List<Film> films = (List<Film>) filmRepository.getFilmsWhichHaveMoreThanXActors(count);
        return films;
    }

    public void deleteFilmbyId(Integer film_id){
        filmRepository.deleteById(film_id);
    }

}
