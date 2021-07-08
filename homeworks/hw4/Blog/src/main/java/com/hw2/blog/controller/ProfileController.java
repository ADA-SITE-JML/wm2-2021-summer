package com.hw2.blog.controller;

import com.hw2.blog.bean.Permission;
import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.entity.User;
import com.hw2.blog.exception.ProfileException;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import com.hw2.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    Logger log = LoggerFactory.getLogger("ProfileLogController");

    @Autowired
    ProfileService profileService;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;


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
        log.warn("You need to login before accessing to this page!");
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
        log.warn("You need to login before accessing to this page!");
        return "redirect:/";
    }


    @GetMapping("/register")
    public String registerView(Model model){

        model.addAttribute("profile", new Profile());
        model.addAttribute("button_text", "Create Profile");
        return "profile/create_profile";
    }

    @PostMapping("/register")
    public String registerUser(HttpSession session,
                               Model model,
                               @Valid @ModelAttribute("profile") Profile profile,
                               BindingResult bindingResult){

            if(bindingResult.hasErrors()){
                log.error("You have some error with fields. Make sure everything is correct with form!");
                model.addAttribute("button_text", "Create Profile");
                return "/profile/create_profile";
            }


            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            } else {
                username = principal.toString();
            }

            User user = userService.getUserByUsername(username);
            profile.setUser(user);

        Profile p = null;
        try {
            p = profileService.saveProfile(profile);
            log.info("Profile successfully created or updated!");
            session.setAttribute("current_user", p);

        } catch (ProfileException e) {
            log.error("Error while update or creating Profile! Error: " + e.getMessage());
            bindingResult.addError(e.getFieldError());
            model.addAttribute("button_text", "Create Profile");
            return "/profile/create_profile";

        } catch (Exception e) {
            log.error("Error while update or creating Profile! Error: Profile with this username exist!");
            bindingResult.addError(new FieldError("profile", "username", "Error message: Profile with this username exist!"));
            model.addAttribute("button_text", "Create Profile");
            return "/profile/create_profile";
        }
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

        log.warn("You need to login before accessing to this page!");
        return "redirect:/";
    }

    @DeleteMapping("/delete/{profileId}")
    public String deleteProfile(HttpSession session, Model model, @PathVariable Integer profileId){
        Profile profile= profileService.getPostById(profileId);
        for(Post post: profile.getLiked_posts()){
            postService.unlikePost(profileId, post.getId());
        }
        profileService.deleteProfile(profileId);
        session.removeAttribute("current_user");
        log.info("Profile successfully removed!");
        return "redirect:/";
    }
}
