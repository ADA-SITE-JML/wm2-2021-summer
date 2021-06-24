package com.hw2.blog.controller;


import com.hw2.blog.entity.Profile;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    ProfileService profileService;

    @Autowired
    PostService postService;

    @GetMapping("")
    public String profiles(Model model){
        return "index";
    }


    @PostMapping("/switch-profile")
    public String switch_profile(HttpSession session, Model model, @RequestParam String username, @RequestParam String password){
        if (profileService.isUserExist(username, password)) {
            Profile profile = profileService.getByNameAndSurname(username, password);
            session.setAttribute("current_user", profile);
            return "redirect:/profile";
        }else{
            model.addAttribute("message", "Username of password Incorrect!");
        }
        return "index";
    }

}
