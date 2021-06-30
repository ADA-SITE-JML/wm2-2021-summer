package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.entity.Game;
import ada.wm2.firstsb.entity.Gamer;
import ada.wm2.firstsb.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gamer")
public class GamerController {
    Logger log = LoggerFactory.getLogger("GamerController");

    @Autowired
    GamerService gamerService;

    @GetMapping("/list")
    public String getGamerList(Model model) {
        List<Gamer> gamerList = gamerService.getGamerList();

        model.addAttribute("gamers", gamerList);
        return "gamer_list";
    }

    @GetMapping("/edit/{id}")
    public String getGamerById(Model model, @PathVariable(name = "id") int id) {

        Gamer gamer = gamerService.getGamerById(id);

        model.addAttribute("gamer", gamer);
        log.info("Gamer info is edited.");
        return "gamer_edit";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public  String update(@ModelAttribute("id") String id, @ModelAttribute("name") String name){

        Gamer gamer = gamerService.getGamerById(Integer.parseInt(id));

        gamer.setId(Integer.parseInt(id));

        gamer.setName(name);

        gamerService.save(gamer);

        return "redirect:/gamer/list";

    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public  String save(@ModelAttribute("name") String name){
        Gamer gamer = new Gamer();
        System.out.println(name);
        gamer.setName(name);
        gamerService.save(gamer);
        return "redirect:/gamer/list";
    }

    @RequestMapping("/delete/{id}")
    public String getGamerDelete(@PathVariable(name = "id") int id) {
        gamerService.delete(id);
        log.info("Gamer is deleted");

        return "redirect:/gamer/list";
    }

}
