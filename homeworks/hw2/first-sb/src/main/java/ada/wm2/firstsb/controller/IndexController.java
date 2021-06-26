package ada.wm2.firstsb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping("/welcome")
    public String showWelcome(Model model){
        model.addAttribute("message", "Welcome 2 wm 2 !");
        return "welcome";
    }

}
