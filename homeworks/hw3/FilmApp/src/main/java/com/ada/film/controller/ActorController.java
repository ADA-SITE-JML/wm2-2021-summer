package com.ada.film.controller;

import com.ada.film.entity.Actor;
import com.ada.film.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/actors")
public class ActorController {

    Logger log = LoggerFactory.getLogger("ActorController");

    @Autowired
    ActorService actorService;

    @GetMapping("/")
    public String actorsView(Model model, @RequestParam(required = false) String by_birth_place,
                             @RequestParam(required = false) Integer by_count){

        List<Actor> list_actors;
        if(by_birth_place != null){
            list_actors = actorService.getActorsByBirthPlace(by_birth_place);
        }
        else if(by_count != null) {
            list_actors = actorService.getActorsByCount(by_count);
        }
        else{
            list_actors = actorService.getAllActors();
            }

        model.addAttribute("actors", list_actors);
        return "actor_list";

    }

    @GetMapping("/new")
    public String newActorView(Model model){
        model.addAttribute("actor", new Actor());
        return "form_actor";
    }

    @GetMapping("/edit/{actor_id}")
    public String editActorView(Model model, @PathVariable Integer actor_id){
        Actor a = actorService.getActorById(actor_id);
        model.addAttribute("actor", a);
        return "form_actor";
    }

    @GetMapping("/{actor_id}")
    public String viewActor(Model model, @PathVariable Integer actor_id){
        Actor a = actorService.getActorById(actor_id);
        model.addAttribute("actor", a);
        return "actor_data";
    }


    @PostMapping("/save")
    public String createNewActor(Model model, @Valid @ModelAttribute("actor") Actor a, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.warn("You have an error with the input data!");
            return "form_actor";
        }

        Actor result_actor = null;
        try {
            result_actor = actorService.saveActor(a);
            log.info("New actor is added!");
        } catch (Exception e) {
            log.error(e.getMessage());
            return "redirect:/error";
        }
        model.addAttribute("actor", result_actor);
        return "redirect:/actors/"+String.valueOf(result_actor.getActor_id());
    }

    @DeleteMapping("/delete/{actor_id}")
    public String deleteActor(Model model, @PathVariable Integer actor_id){
        actorService.deleteActorbyId(actor_id);
        log.info("Your actor information is deleted!");
        return "redirect:/actors/";
    }

}
