package com.ada.film.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ErrorControl {
    Logger log = LoggerFactory.getLogger("ErrorControl");

    @GetMapping("/error")
    public String ErrorPage(Model model){
        log.info("You have an error!");
        return "error";
    }
}
