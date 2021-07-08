package com.assignment02.assignment.controller;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.service.PlayerService;
import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(value = {"/all", "/"})
    public String getPlayers(Model model) {
        logger.info("PlayerController.getPlayers()");
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/{id}")
    public String getPlayer(Model model, @PathVariable Long id) {
        logger.info("PlayerController.getPlayer({})", id);
        Player player = playerService.getPlayer(id);
        model.addAttribute("player", player);
        return "player";
    }

    @GetMapping("/create")
    public String showPlayerForm(Model model) {
        logger.info("PlayerController.showPlayerForm()");
        model.addAttribute("player", new Player());
        return "player_new";
    }

    @GetMapping("/edit/{id}")
    public String showPlayerForm(Model model, @PathVariable Long id) {
        logger.info("PlayerController.showPlayerForm({})", id);
        Player player = playerService.getPlayer(id);
        model.addAttribute("player", player);
        return "player_form";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Player player, BindingResult bindingResult) {
        logger.info("PlayerController.save({})", player);
        if (bindingResult.hasErrors())
            return "player_new";
        Player updatedPlayer = playerService.savePlayer(player);
        model.addAttribute("players", playerService.getPlayers());
        return "redirect:/player/all";
    }

    @PostMapping("/save_edits")
    public String saveEdits(Model model, @Valid Player player, BindingResult bindingResult) {
        logger.info("PlayerController.saveEdits({})", player);
        if (bindingResult.hasErrors())
            return "player_form";
        playerService.saveChangesToPlayer(player);
        model.addAttribute("players", playerService.getPlayers());
        return "redirect:/player/all";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(Model model, @PathVariable Long id) {
        logger.info("PlayerController.deletePlayer({})", id);
        playerService.deletePlayer(id);
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/{id}/become_free")
    public String becomeFree(Model model, @PathVariable Long id) {
        logger.info("PlayerController.becomeFree({})", id);
        playerService.becomeFree(id);
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/search")
    public String searchPlayersByName(Model model, @RequestParam(name = "name") String playerName) {
        logger.info("PlayerController.searchPlayersByName({})", playerName);
        model.addAttribute("players", playerService.getPlayersByName(playerName));
        return "players";
    }
}
