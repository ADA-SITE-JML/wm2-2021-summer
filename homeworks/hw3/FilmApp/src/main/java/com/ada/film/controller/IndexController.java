package com.ada.film.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    Logger log = LoggerFactory.getLogger("IndexController");


    @GetMapping("/login")
    public String showLogin() {
        return "login_page";
    }

    @GetMapping("/")
    public String enterProject(){
        log.info("You are redirecting to \"/films/\" page!");
        return "redirect:/films/";
    }
}
