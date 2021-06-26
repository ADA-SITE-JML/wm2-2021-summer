package com.assignment02.assignment.service;

import com.assignment02.assignment.bean.PlayerBean;
import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    public Player getPlayer(Long playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        return optionalPlayer.orElse(new Player("Nothing", "Found"));
    }

    public Player getPlayersByName(String name) {
        Optional<Player> optionalPlayer = playerRepository.findPlayersByFirstName(name);
        return optionalPlayer.orElse(new Player("Nothing", "Found"));
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Transactional
    public void deletePlayer(Long id) {
        playerRepository.deletePlayerFromTeamById(id);
        playerRepository.deletePlayerById(id);
    }

    @Transactional
    public void saveChangesToPlayer(Player player) {
        playerRepository.updatePlayer(player.getFirstName(), player.getLastName(), player.getId());
    }

    @Transactional
    public void becomeFree(Long id) {
        playerRepository.deletePlayerFromTeamById(id);
    }

//    public List<Player> getFreePlayers() {
//        return playerRepository.freePlayers();
//    }
}
