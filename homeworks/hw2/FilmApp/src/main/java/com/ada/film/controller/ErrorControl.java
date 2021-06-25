package com.ada.film.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ErrorControl {

    @GetMapping("/error")
    public String ErrorPage(Model model){
        return "error";
    }
}
