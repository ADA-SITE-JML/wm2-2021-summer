package ada.wm2.sbhw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/welcome")
    public String showWelcome(Model model){
        model.addAttribute("message", "Welcome to W&M 2!");
        return "welcome";
    }
}
