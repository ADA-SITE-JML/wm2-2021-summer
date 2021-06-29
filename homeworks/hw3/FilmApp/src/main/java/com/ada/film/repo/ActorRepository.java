package com.ada.film.repo;


import com.ada.film.entity.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ActorRepository extends CrudRepository<Actor, Integer> {



    @Query(value = "select a from Actor a where upper(a.birth_place)=upper(?1)")
    Iterable<Actor> getActorsByBirthPlace(String category);

    @Query(value = "select a.* from actor a where (select count(*) from films_actors group by actor_id having actor_id=a.actor_id) >?;", nativeQuery = true)
    Iterable<Actor> getActorsWhichPlayedInMoreThanXFilms(Integer count);

    @Query(value = "SELECT a.* FROM actor AS a, films_actors AS fa WHERE a.actor_id = fa.actor_id AND fa.film_id=?", nativeQuery = true)
    Iterable<Actor> getActorsOfFilm(Integer film_id);



    




}
