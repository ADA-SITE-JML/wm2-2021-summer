package com.assignment02.assignment.controller;

import com.assignment02.assignment.entity.Player;
import com.assignment02.assignment.entity.Team;
import com.assignment02.assignment.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping(value = {"/all", "/"})
    public String getTeams(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        return "teams";
    }

    @GetMapping("/{id}")
    public String getTeam(Model model, @PathVariable Long id) {
        model.addAttribute("team", teamService.getTeam(id));
        return "team";
    }

    @GetMapping("/create")
    public String showTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "team_new";
    }

    @GetMapping("/edit/{id}")
    public String showTeamForm(Model model, @PathVariable Long id) {
        Team team = teamService.getTeam(id);
        model.addAttribute("team", team);
        return "team_form";
    }

    @PostMapping("/save")
    public String save(Model model, Team team) {
        Team updatedTeam = teamService.saveTeam(team);
        model.addAttribute("teams", teamService.getTeams());
        return "teams";
    }

    @PostMapping("/save_edits")
    public String saveEdits(Model model, Team team) {
        teamService.saveChangesToTeam(team);
        model.addAttribute("teams", teamService.getTeams());
        return "teams";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(Model model, @PathVariable Long id) {
        teamService.deleteTeam(id);
        model.addAttribute("teams", teamService.getTeams());
        return "teams";
    }

    @GetMapping("/remove_player/{teamId}/{playerId}")
    public String removePlayer(Model model, @PathVariable(name = "teamId") Long teamId,
                               @PathVariable(name = "playerId") Long playerId) {
        teamService.removePlayer(teamId, playerId);
        model.addAttribute("team", teamService.getTeam(teamId));
        return "team_form";
    }

    @GetMapping("/search")
    public String searchTeamByName(Model model, @RequestParam(name = "name") String teamName) {
        model.addAttribute("teams", teamService.getTeamByName(teamName));
        return "teams";
    }
}
