package com.assignment02.assignment.controller;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.service.PlayerService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(value = {"/all", "/"})
    public String getPlayers(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/{id}")
    public String getPlayer(Model model, @PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        model.addAttribute("player", player);
        return "player";
    }

    @GetMapping("/create")
    public String showPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "player_new";
    }

    @GetMapping("/edit/{id}")
    public String showPlayerForm(Model model, @PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        model.addAttribute("player", player);
        return "player_form";
    }

    @PostMapping("/save")
    public String save(Model model, Player player) {
        Player updatedPlayer = playerService.savePlayer(player);
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @PostMapping("/save_edits")
    public String saveEdits(Model model, Player player) {
        playerService.saveChangesToPlayer(player);
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(Model model, @PathVariable Long id) {
        playerService.deletePlayer(id);
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/{id}/become_free")
    public String becomeFree(Model model, @PathVariable Long id) {
        playerService.becomeFree(id);
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

//    @GetMapping("/free")
//    public String getFreePlayers(Model model) {
//        List<Player> playerList = playerService.getFreePlayers();
//        System.out.println(playerList);
//        model.addAttribute("players", playerList);
//        return "team_available_players";
//    }

    @GetMapping("/search")
    public String searchPlayersByName(Model model, @RequestParam(name = "name") String playerName) {
        model.addAttribute("players", playerService.getPlayersByName(playerName));
        return "players";
    }
}
