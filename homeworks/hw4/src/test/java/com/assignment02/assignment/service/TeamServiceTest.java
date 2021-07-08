package com.assignment02.assignment.service;

import com.assignment02.assignment.entity.Team;
import com.assignment02.assignment.repository.TeamRepository;
import com.assignment02.assignment.service.TeamService;
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
public class TeamServiceTest {

    @Mock
    TeamRepository repository;

    @InjectMocks
    TeamService service;

    @Test
    @DisplayName("Test getTeams(). Expected to get size of 2")
    void testGetTeams() {
        // Given
        Team team1 = new Team();
        Team team2 = new Team();
        List<Team> teamList = List.of(team1, team2);
        given(repository.findAll()).willReturn(teamList);

        // When
        List<Team> teams = service.getTeams();

        // Then
        then(repository).should().findAll();
        assertThat(teams).hasSize(2);
    }

    @Test
    @DisplayName("test getTeam(). Expected that found result is not null")
    void testGetTeam() {
        // Given
        Team team = new Team();
        given(repository.findById(anyLong())).willReturn(Optional.of(team));

        // When
        Team foundTeam = service.getTeam(anyLong());

        // Then
        then(repository).should().findById(anyLong());
        assertThat(foundTeam).isNotNull();
    }

    @Test
    @DisplayName("Test saveTeam(). Expected that the saved team is not null")
    void testSaveTeam() {
        // Given
        Team team = new Team();
        given(repository.save(team)).willReturn(team);

        // When
        Team savedTeam = service.saveTeam(team);

        // Then
        then(repository).should().save(team);
        assertThat(savedTeam).isNotNull();
    }

    @Test
    @DisplayName("Test getTeamByName(). Expected that found team is not null")
    void testGetTeamByName() {
        // Given
        Team team = new Team();
        given(repository.findTeamByName(anyString())).willReturn(Optional.of(team));

        // When
        Team foundTeam = service.getTeamByName(anyString());

        // Then
        then(repository).should().findTeamByName(anyString());
        assertThat(foundTeam).isNotNull();
    }
}
