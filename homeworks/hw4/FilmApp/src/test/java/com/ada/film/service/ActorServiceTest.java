package com.ada.film.service;


import com.ada.film.entity.Actor;
import com.ada.film.repo.ActorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class ActorServiceTest {


    @Mock
    ActorRepository actorRepository;

    @InjectMocks
    ActorService actorService;


    @Test
    @DisplayName("Test get all actors")
    void getAllActors(){
        Actor a = new Actor();
        Actor a1 = new Actor();
        Actor a2 = new Actor();
        List<Actor> actors = new ArrayList<>();
        actors.add(a);
        actors.add(a1);
        actors.add(a2);

        given(actorRepository.findAll()).willReturn(actors);

        List<Actor> result = actorService.getAllActors();

        then(actorRepository).should().findAll();

        assertThat(result).hasSize(3);

    }


    @Test
    void testGetActor(){
        Actor a = new Actor();

        given(actorRepository.findById(anyInt())).willReturn(Optional.of(a));

        Actor result = actorService.getActorById(anyInt());

        then(actorRepository).should().findById(anyInt());

        assertThat(result).isNotNull();

    }

    @Test
    void testSaveActor() throws Exception {

        Actor a = new Actor();

        given(actorRepository.save(a)).willReturn(a);

        Actor saved = actorService.saveActor(a);

        then(actorRepository).should().save(any(Actor.class));
        assertThat(saved).isNotNull();


    }

}
