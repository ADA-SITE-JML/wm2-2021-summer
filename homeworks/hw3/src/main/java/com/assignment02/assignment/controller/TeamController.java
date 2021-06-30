package com.assignment02.assignment.controller;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.entity.Team;
import com.assignment02.assignment.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    TeamService teamService;

    @GetMapping(value = {"/all", "/"})
    public String getTeams(Model model) {
        logger.info("TeamController.getTeams()");
        model.addAttribute("teams", teamService.getTeams());
        return "teams";
    }

    @GetMapping("/{id}")
    public String getTeam(Model model, @PathVariable Long id) {
        logger.info("TeamController.getTeam({})", id);
        model.addAttribute("team", teamService.getTeam(id));
        return "team";
    }

    @GetMapping("/create")
    public String showTeamForm(Model model) {
        logger.info("TeamController.showTeamForm()");
        model.addAttribute("team", new Team());
        return "team_new";
    }

    @GetMapping("/edit/{id}")
    public String showTeamForm(Model model, @PathVariable Long id) {
        logger.info("TeamController.showTeamForm()");
        Team team = teamService.getTeam(id);
        model.addAttribute("team", team);
        return "team_form";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Team team, BindingResult bindingResult) {
        logger.info("TeamController.save({})", team);
        if (bindingResult.hasErrors()) {
            return "team_new";
        }
        Team updatedTeam = teamService.saveTeam(team);
        model.addAttribute("teams", teamService.getTeams());
        return "redirect:/team/all";
    }

    @PostMapping("/save_edits")
    public String saveEdits(Model model, @Valid Team team, BindingResult bindingResult) {
        logger.info("TeamController.saveEdits({})", team);
        if (bindingResult.hasErrors()) {
            return "team_form";
        }
        teamService.saveChangesToTeam(team);
        model.addAttribute("teams", teamService.getTeams());
        return "redirect:/team/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(Model model, @PathVariable Long id) {
        logger.info("TeamController.deleteTeam({})", id);
        teamService.deleteTeam(id);
        model.addAttribute("teams", teamService.getTeams());
        return "teams";
    }

    @GetMapping("/remove_player/{teamId}/{playerId}")
    public String removePlayer(Model model, @PathVariable(name = "teamId") Long teamId,
                               @PathVariable(name = "playerId") Long playerId) {
        logger.info("TeamController.removePlayer(teamId: {}, playerId: {})", teamId, playerId);
        teamService.removePlayer(teamId, playerId);
        model.addAttribute("team", teamService.getTeam(teamId));
        return "team_form";
    }

    @GetMapping("/search")
    public String searchTeamByName(Model model, @RequestParam(name = "name") String teamName) {
        logger.info("TeamController.searchTeamByName(teamName: {})", teamName);
        model.addAttribute("teams", teamService.getTeamByName(teamName));
        return "teams";
    }
}
