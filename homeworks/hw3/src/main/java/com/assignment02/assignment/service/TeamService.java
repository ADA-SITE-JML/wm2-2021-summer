package com.assignment02.assignment.service;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.entity.Team;
import com.assignment02.assignment.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getTeams() {
        logger.debug("getTeams()");
        return (List<Team>) teamRepository.findAll();
    }

    public Team getTeam(Long teamId) {
        logger.debug("getTeam({})", teamId);
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return optionalTeam.orElse(new Team("Nothing"));
    }

    @Transactional
    public void saveChangesToTeam(Team team) {
        logger.debug("saveChangesToTeam({})", team);
        teamRepository.updateTeam(team.getName(), team.getId());
    }

    public Team saveTeam(Team team) {
        logger.debug("saveTeam({})", team);
        return teamRepository.save(team);
    }

    @Transactional
    public void deleteTeam(Long id) {
        logger.debug("deleteTeam({})", id);
        teamRepository.deleteTeamPlayersById(id);
        teamRepository.deleteTeamById(id);
    }

    @Transactional
    public void removePlayer(Long teamId, Long playerId) {
        logger.debug("removePlayer({}, {})", teamId, playerId);
        teamRepository.removePlayer(teamId, playerId);
    }

    public Team getTeamByName(String name) {
        logger.debug("getTeamByName({})", name);
        Optional<Team> optionalTeam = teamRepository.findTeamByName(name);
        return optionalTeam.orElse(new Team("Nothing Found"));
    }
}
