package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.entity.Game;
import ada.wm2.firstsb.entity.Gamer;
import ada.wm2.firstsb.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller

@RequestMapping("/game")
public class GameController {
    Logger log = LoggerFactory.getLogger("GameController");



    @Autowired
    GameService gameService;

    @GetMapping("/list")
    public String getGameList(Model model) {
        List<Game> gameList = gameService.getGameList();

        model.addAttribute("games", gameList);
        return "game_list";
    }

    @GetMapping("/edit/{id}")
    public String getGameById(Model model, @PathVariable(name = "id") int id) {

        Game game = gameService.getGameById(id);

        model.addAttribute("game", game);
        log.info("Your game is edited.");
        return "game_edit";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public  String update(@ModelAttribute("id") String id, @ModelAttribute("name") String name){

        Game game = gameService.getGameById(Integer.parseInt(id));

        game.setId(Integer.parseInt(id));

        game.setNAME(name);

        gameService.save(game);

        return "redirect:/game/list";

    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public  String save(@ModelAttribute("name") String name){

        Game game = new Game();
        game.setNAME(name);

        gameService.save(game);

        return "redirect:/game/list";

    }

    @RequestMapping("/delete/{id}")
    public String getGameDelete(@PathVariable(name = "id") int id) {
        gameService.delete(id);
        log.info("Your game is deleted");
        return "redirect:/game/list";
    }


}
