package com.assignment02.assignment.service;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.repository.PlayerRepository;
import com.assignment02.assignment.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    PlayerRepository repository;

    @InjectMocks
    PlayerService service;

    @Test
    @DisplayName("Expected to get 2 players when getPlayers() is called")
    void testGetPlayers() {
        // Given
        Player player1 = new Player();
        Player player2 = new Player();
        List<Player> playerList = List.of(player1, player2);
        given(repository.findAll()).willReturn(playerList);

        // When
        List<Player> players = service.getPlayers();

        // Then
        then(repository).should().findAll();
        assertThat(players).hasSize(2);
    }

    @Test
    @DisplayName("Find a single player for a given id. Found Player should not be null")
    void testGetPlayer() {
        // Given
        Player player = new Player();
        given(repository.findById(anyLong())).willReturn(Optional.of(player));

        // When
        Player foundPlayer = service.getPlayer(anyLong());

        // Then
        then(repository).should().findById(anyLong());
        assertThat(foundPlayer).isNotNull();
    }

    @Test
    @DisplayName("Test savePlayer(). Saved Player should not be null")
    void savePlayer() {
        // Given
        Player player = new Player();
        given(repository.save(player)).willReturn(player);

        // When
        Player savedPlayer = service.savePlayer(player);

        // Then
        then(repository).should().save(player);
        assertThat(savedPlayer).isNotNull();
    }

    @Test
    @DisplayName("Test getPlayersByName(). Expected that the found player is not null")
    void testGetPlayersByName() {
        // Given
        Player player = new Player();
        given(repository.findPlayersByFirstName(anyString())).willReturn(Optional.of(player));

        // When
        Player foundPlayer = service.getPlayersByName(anyString());

        // Then
        then(repository).should().findPlayersByFirstName(anyString());
        assertThat(foundPlayer).isNotNull();
    }
}
