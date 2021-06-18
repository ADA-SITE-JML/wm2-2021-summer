package ada.wm2.firstsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    private String greetText;

    @GetMapping("/welcome")
    public String showWelcome(Model model) {
        model.addAttribute("message", greetText);
        return "welcome";
    }

    @GetMapping("/datetest")
    public String testDateInput(Model model, @RequestParam Date startDate) {
        model.addAttribute("message","Date is :"+startDate);
        return "welcome";
    }

    // Will take it out to MvcConfig
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

}
