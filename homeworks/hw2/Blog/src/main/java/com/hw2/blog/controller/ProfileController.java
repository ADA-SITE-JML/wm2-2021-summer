package com.hw2.blog.controller;

import com.hw2.blog.bean.Permission;
import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import org.dom4j.rule.Mode;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    PostService postService;


    @GetMapping("")
    public String profileInfo(HttpSession session, Model model){

        Profile profile = (Profile) session.getAttribute("current_user");
        if (profile != null){
            List<Post> post_list = postService.getPostByAuthor(profile);
            model.addAttribute("posts", post_list);
            model.addAttribute("permission", new Permission(profileService));
            model.addAttribute("profile", profile);
            return "profile/profile";
        }

        return "redirect:/";
    }

    @GetMapping("{profileId}")
    public String profileInfo(HttpSession session, Model model, @PathVariable Integer profileId){
        Profile profile = (Profile) session.getAttribute("current_user");
        if (profile != null){
            Profile visited = profileService.getPostById(profileId);
            if(profile.equalsTo(visited))
                return "redirect:/profile";
            List<Post> post_list = postService.getPostByAuthor(visited);
            model.addAttribute("posts", post_list);
            model.addAttribute("profile", visited);
            model.addAttribute("permission", new Permission(profileService));
            return "profile/profile";
        }

        return "redirect:/";
    }


    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("profile", new Profile());
        model.addAttribute("button_text", "Register");
        return "profile/create_profile";
    }

    @PostMapping("/save")
    public String registerUser(HttpSession session,Model model, Profile profile){
            Profile p = profileService.saveProfile(profile);
            session.setAttribute("current_user", p);
            return "redirect:/profile";
    }

    @GetMapping("/edit")
    public String editUser(HttpSession session, Model model){
        Permission permission = new Permission();
        // check user is logged in
        if(permission.isLoggedIn(session)){
            Profile profile = (Profile) session.getAttribute("current_user");
            model.addAttribute("profile", profile);
            model.addAttribute("button_text", "Edit Profile");
            return "profile/create_profile";
        }

        return "redirect:/";
    }


}
