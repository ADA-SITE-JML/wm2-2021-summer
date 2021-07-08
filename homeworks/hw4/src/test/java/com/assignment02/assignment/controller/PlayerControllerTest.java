package com.assignment02.assignment.controller;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {

    @Mock
    PlayerService service;

    @InjectMocks
    PlayerController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Test getPlayers()")
    void testGetPlayers() throws Exception {
        mockMvc.perform(get("/player/all"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("players"))
                .andExpect(view().name("players"));
    }

    @Test
    @DisplayName("Test getPlayer()")
    void testGetPlayer() throws Exception {
        when(service.getPlayer(anyLong())).thenReturn(new Player());

        mockMvc.perform(get("/player/{id}", anyLong()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("player"))
                .andExpect(view().name("player"));
    }

    @Test
    @DisplayName("Test showPlayerForm() for creating player")
    void testShowPlayerFormCreate() throws Exception {
        mockMvc.perform(get("/player/create"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("player"))
                .andExpect(view().name("player_new"));
    }

    @Test
    @DisplayName("Test showPlayerForm() for editing player")
    void testShowPlayerForm() throws Exception {
        when(service.getPlayer(anyLong())).thenReturn(new Player());

        mockMvc.perform(get("/player/edit/{id}", anyLong()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("player"))
                .andExpect(view().name("player_form"));
    }

    @Test
    @DisplayName("Test save() with get request. Expected to return 405 Method Not Allowed error")
    void testSaveGetRequest() throws Exception {
        mockMvc.perform(get("/player/save"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Test save() with post request")
    void testSavePostRequest() throws Exception {
        mockMvc.perform(post("/player/save"))
                .andExpect(status().isOk())
                .andExpect(view().name("player_new"));
    }

    @Test
    @DisplayName("test saveEdits()")
    void testSaveEdits() throws Exception {
        mockMvc.perform(post("/player/save_edits"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test deletePlayer()")
    void testDeletePlayer() throws Exception {
        List<Player> playerList = List.of(new Player());
        when(service.getPlayers()).thenReturn(playerList);

        mockMvc.perform(get("/player/delete/{id}", anyLong()))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("players"))
                .andExpect(view().name("players"));
    }

    @Test
    @DisplayName("test becomeFree()")
    void testBecomeFree() throws Exception {
        mockMvc.perform(get("/player/{id}/become_free", anyLong()))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("players"))
                .andExpect(view().name("players"));
    }

    @Test
    @DisplayName("test searchPlayersByName()")
    void testSearchPlayersByName() throws Exception {
        when(service.getPlayersByName(anyString())).thenReturn(new Player());

        mockMvc.perform(get("/player/search")
                .param("name", anyString()))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("players"))
                .andExpect(view().name("players"));
    }

}
