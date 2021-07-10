package com.ada.film.service;

import com.ada.film.entity.Actor;
import com.ada.film.helper.HelperClass;
import com.ada.film.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public List<Actor> getAllActors(){
        List<Actor> actors = (List<Actor>) actorRepository.findAll();
        return actors;
    }

    public Actor getActorById(Integer id){
        Optional<Actor> a = actorRepository.findById(id);
        if (a.isPresent()){
            return a.get();
        }
        return new Actor();
    }

    public Actor saveActor(Actor a) throws Exception {
        Actor result_actor = null;
        a.setFirst_name(HelperClass.changeString(a.getFirst_name()));
        a.setLast_name(HelperClass.changeString(a.getLast_name()));
        result_actor = actorRepository.save(a);
        return result_actor;
    }

    public List<Actor> getActorsByBirthPlace(String birth_place){
        List<Actor> actors = (List<Actor>) actorRepository.getActorsByBirthPlace(birth_place);
        return actors;
    }

    public List<Actor> getActorsByCount(Integer count){
        List<Actor> actors = (List<Actor>) actorRepository.getActorsWhichPlayedInMoreThanXFilms(count);
        return actors;
    }

    public List<Actor> getActorsOfFilm(Integer film_id){
        List<Actor> actors = (List<Actor>) actorRepository.getActorsOfFilm(film_id);
        return actors;
    }

    public void deleteActorbyId(Integer actor_id) { actorRepository.deleteById(actor_id);}
}
