package com.assignment02.assignment.service;

import com.assignment02.assignment.bean.PlayerBean;
import com.assignment02.assignment.controller.IndexController;
import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        logger.info("getPlayers()");
        return (List<Player>) playerRepository.findAll();
    }

    public Player getPlayer(Long playerId) {
        logger.info("getPlayer({})", playerId);
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        return optionalPlayer.orElse(new Player("Nothing", "Found"));
    }

    public Player getPlayersByName(String name) {
        logger.info("getPlayersByName({})", name);
        Optional<Player> optionalPlayer = playerRepository.findPlayersByFirstName(name);
        return optionalPlayer.orElse(new Player("Nothing", "Found"));
    }

    public Player savePlayer(Player player) {
        logger.info("savePlayer({})", player);
        return playerRepository.save(player);
    }

    @Transactional
    public void deletePlayer(Long id) {
        logger.info("deletePlayer({})", id);
        playerRepository.deletePlayerFromTeamById(id);
        playerRepository.deletePlayerById(id);
    }

    @Transactional
    public void saveChangesToPlayer(Player player) {
        logger.info("saveChangesToPlayer({})", player);
        playerRepository.updatePlayer(player.getFirstName(), player.getLastName(), player.getId());
    }

    @Transactional
    public void becomeFree(Long id) {
        logger.info("becomeFree({})", id);
        playerRepository.deletePlayerFromTeamById(id);
    }
}
