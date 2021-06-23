package com.ada.film.repo;

import com.ada.film.entity.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    Iterable<Film> getFilmsByTitle(String title);


    @Query(value = "select f from Film f where f.film_category=?1")
    Iterable<Film> getFilmsByCategory(String category);

    @Query(value = "select f.* from films f where f.title=? and (select count(*) from films_actors group by film_id having film_id=f.film_id) >?;", nativeQuery = true)
    Iterable<Film> getFilmsByTitleWhichHaveMoreThanXActors(String title, Integer count);
}
