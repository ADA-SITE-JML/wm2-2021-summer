package com.ada.film.controller;

import com.ada.film.service.ActorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class ActorControllerTest {

    @Mock
    ActorService actorService;

    @Mock
    Map<String, Integer> model;

    @InjectMocks
    ActorController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testShowEditForm() throws Exception {
            mockMvc.perform(get("/actors/edit/1"))
                    .andExpect(status().isOk())
            //        .andExpect(model().attributeExists("actor"))
                    .andExpect(view().name("form_actor"));
    }

//    @Test
//    void
}
