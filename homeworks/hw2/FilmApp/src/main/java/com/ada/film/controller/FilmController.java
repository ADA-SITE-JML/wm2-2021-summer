package com.ada.film.controller;


import com.ada.film.entity.Actor;
import com.ada.film.entity.Film;
import com.ada.film.service.ActorService;
import com.ada.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    ActorService actorService;

    @GetMapping("/")
    public String filmsView(Model model, @RequestParam(required = false) String by_category,
                            @RequestParam(required = false) Integer by_count){
        List<Film> list_films;
        if(by_category != null){
            list_films = filmService.getFilmsByCategory(by_category);
        }
        else if (by_count != null){
            list_films = filmService.getFilmsByCount(by_count);
        }else{
            list_films = filmService.getAllFilms();
        }

        model.addAttribute("films", list_films);
        return "film_list";
    }

    @GetMapping("/new")
    public String newFilmView(Model model){
        List<Actor> list_actors=actorService.getAllActors();
        model.addAttribute("film", new Film());
        model.addAttribute("actors", list_actors);
        return "form_film";
    }

    @GetMapping("/edit/{film_id}")
    public String editFilmView(Model model, @PathVariable Integer film_id){
        Film f = filmService.getFilmById(film_id);
        List<Actor> list_actors=actorService.getAllActors();
        model.addAttribute("actors", list_actors);
        model.addAttribute("film", f);
        return "form_film";
    }

    @GetMapping("/{film_id}")
    public String viewFilm(Model model, @PathVariable Integer film_id){
        Film f = filmService.getFilmById(film_id);
        List<Actor> a = actorService.getActorsOfFilm(film_id);
        model.addAttribute("film", f);
        model.addAttribute("actors", a);
        return "film_data";
    }


    @PostMapping("/save")
    public String createNewFilm(Model model, Film f){
        Film result_film = filmService.saveFilm(f);
        model.addAttribute("film", result_film);
        return "redirect:/films/"+String.valueOf(result_film.getFilm_id());
    }


    @DeleteMapping("/delete/{film_id}")
    public String deleteFilm(Model model, @PathVariable Integer film_id){
        filmService.deleteFilmbyId(film_id);
        return "redirect:/films/";
    }

}
