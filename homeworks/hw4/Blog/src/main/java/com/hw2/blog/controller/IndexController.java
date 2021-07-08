package com.hw2.blog.controller;

import com.hw2.blog.entity.Profile;
import com.hw2.blog.entity.User;
import com.hw2.blog.entity.UserRole;
import com.hw2.blog.exception.UserException;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import com.hw2.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {

    Logger log = LoggerFactory.getLogger("IndexLogController");

    @Autowired
    ProfileService profileService;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public String profiles(Model model){
        return "index";
    }


    @PostMapping("/switch-profile")
    public String switch_profile(HttpSession session, Model model, @RequestParam String username, @RequestParam String password){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user_username;
        if (principal instanceof UserDetails) {
            user_username = ((UserDetails)principal).getUsername();
        } else {
            user_username = principal.toString();
        }
        User user = userService.getUserByUsername(user_username);

        if (profileService.isUserExist(user, username, password)) {
            Profile profile = profileService.getByNameAndSurname(username, password);
            log.info("User with '" + username + "' has successfully logged in!");
            session.setAttribute("current_user", profile);
            return "redirect:/profile";
        }else{
            log.error("Error while login! Username or password is Incorrect!");
            model.addAttribute("message", "Username of password Incorrect!");
        }
        return "index";
    }

    @GetMapping("/switch-profile")
    public String redirectToLogin(Model model){
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginView(Model model){
        return "login";
    }

    @GetMapping("/signup")
    public String signupView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/signup")
    public String signupView(Model model,
                             @Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Error while creating new User. You have some error with fields. Make sure everything is correct with form!");
            return "register";
        }
        user.setEnabled(true);
        user.setLocked(false);
        user.setUserRole(UserRole.USER);
        try {
            User new_user = userService.registerUser(user);
            log.info("New user " + new_user.getUsername() + " has successfully created!");
        }catch (UserException e) {
            log.error("Error while creating new User! Error: " + e.getMessage());
            bindingResult.addError(e.getFieldError());
            return "register";
        } catch (Exception e) {
            log.error("Error while creating new User! Error: " + e.getMessage());
            bindingResult.addError(new FieldError("user", "username", "Error message: " + e.getMessage()));
            return "register";
        }
        return "redirect:/";
    }


    @GetMapping(value="/logout")
    public String logoutView(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        log.info("You have successfully logout from Spring Security Auth!");
        return "redirect:/login?logout";
    }

}
