package com.assignment02.assignment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/welcome")
    public String showWelcome(Model model) {
        model.addAttribute("message", "Welcome page");
        return "welcome";
    }
}
