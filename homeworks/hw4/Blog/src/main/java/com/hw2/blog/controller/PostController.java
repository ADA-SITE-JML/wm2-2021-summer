package com.hw2.blog.controller;

import com.hw2.blog.bean.Permission;
import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.exception.PostException;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

    Logger log = LoggerFactory.getLogger("PostLogController");

    @Autowired
    PostService postService;

    @Autowired
    ProfileService profileService;

    @GetMapping("")
    public String listPosts(HttpSession session, Model model){
        Profile profile = (Profile) session.getAttribute("current_user");
        if (profile != null){
            List<Post> post_list = postService.getAllPosts();

            model.addAttribute("header", "All Posts");
            model.addAttribute("url", "/posts/");
            model.addAttribute("posts", post_list);
            model.addAttribute("post", new Post(profile));
            model.addAttribute("permission", new Permission(profileService));
            return "posts/posts";
        }

        log.warn("You need to login before accessing to this /posts page!");
        return "redirect:/";
    }

    @GetMapping("/liked")
    public String likedPosts(HttpSession session, Model model){
        Profile profile = (Profile) session.getAttribute("current_user");
        if (profile != null){
            List<Post> post_list = postService.getLikedPosts(profile.getId());
            model.addAttribute("header", "Like Posts");
            model.addAttribute("url", "/posts/liked");
            model.addAttribute("post", new Post(profile));
            model.addAttribute("permission", new Permission(profileService));
            model.addAttribute("posts", post_list);
            return "posts/posts";
        }

        log.warn("You need to login before accessing to /liked page!");
        return "redirect:/";
    }

    @PostMapping("")
    public String createPostView(HttpSession session,
                                 Model model,
                                 @Valid @ModelAttribute("post") Post post,
                                 BindingResult bindingResult){
        System.out.println(bindingResult.getAllErrors());
        if(bindingResult.hasErrors()){
            log.error("Error while creating a Post. You have some error with fields. Make sure everything is correct with form!");
            model.addAttribute("header", "All Posts");
            model.addAttribute("url", "/posts/");
            model.addAttribute("posts", postService.getAllPosts());
            model.addAttribute("permission", new Permission(profileService));
            return "posts/posts";
        }

        Profile profile = (Profile) session.getAttribute("current_user");
        if (profile != null){
            post.setAuthor(profile);
            Post pst = postService.savePost(post);
            log.info("New post successfully created!");
            return "redirect:/posts";
        }
        log.warn("You need to login before posting to /posts url!");
        return "redirect:/";
    }


    @GetMapping("/edit/{postId}")
    public ModelAndView editPostView(HttpSession session,
                                     Model model,
                                     @PathVariable Integer postId,
                                     final RedirectAttributes redirectAttributes){
        Permission permission = new Permission();
        ModelAndView modelAndView = null;
        // check user is logged in
        if(permission.isLoggedIn(session)){
            Profile profile = (Profile) session.getAttribute("current_user");
            try {
                Post pst = postService.getPost(postId, profile);
                modelAndView = new ModelAndView("posts/edit_post");
                modelAndView.addObject("post", pst);
                modelAndView.addObject("permission", new Permission(profileService));
                return modelAndView;
            } catch (PostException e) {
                log.error("Error while getting edit page! " + e.getMessage());
                modelAndView = new ModelAndView("redirect:/error");
                redirectAttributes.addFlashAttribute("error", "Error while getting edit page! " + e.getMessage());
                return modelAndView;
            }

        }
        log.warn("You need to login before accessing to this /posts/edit/{postId} page!");
        modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @PostMapping("/edit/{postId}")
    public ModelAndView editPost(HttpSession session, Model model,
                           @PathVariable Integer postId,
                           @Valid @ModelAttribute("post") Post post,
                           BindingResult bindingResult,
                           final RedirectAttributes redirectAttributes){
            ModelAndView modelAndView = null;
            if(bindingResult.hasErrors()){
                log.error("Error while updated a Post. You have some error with fields. Make sure everything is correct with form!");
                modelAndView = new ModelAndView("posts/edit_post");
                modelAndView.addObject("permission", new Permission(profileService));
                return modelAndView;
            }

            Permission permission = new Permission();
            // check user is logged in
            if(permission.isLoggedIn(session)){
                Profile profile = (Profile) session.getAttribute("current_user");
                Post pst = null;
                try {
                    pst = postService.getPost(postId, profile);
                    boolean is_there = profileService.isLiked(profile.getId(), postId);
                    post.setAuthor(profile);
                    postService.savePost(post);
                    if(is_there){
                        postService.likePost(profile.getId(), postId);
                    }
                    log.info("Post with id (" + postId + ") has successfully updated!");
                    modelAndView = new ModelAndView("redirect:/posts");
                    return modelAndView;
                } catch (PostException e) {
                    log.error("Error while getting edit page! " + e.getMessage());
                    modelAndView = new ModelAndView("redirect:/error");
                    redirectAttributes.addFlashAttribute("error", "Error while editing page! " + e.getMessage());
                    return modelAndView;
                }
            }
            log.warn("You need to login before posting to /posts/edit/{postId} url!");
            modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
    }


    @DeleteMapping("/delete/{postId}")
    public ModelAndView deletePostView(HttpSession session,
                                       Model model,
                                       @PathVariable Integer postId,
                                       final RedirectAttributes redirectAttributes){
        Permission permission = new Permission();
        ModelAndView modelAndView = null;
        // check user is logged in
        if(permission.isLoggedIn(session)){
            // check user has permission to delete
            Profile profile = (Profile) session.getAttribute("current_user");
            try {
                postService.deletePost(postId, profile);
                log.info("Post with id (" + postId + ") has successfully deleted!");
                modelAndView = new ModelAndView("redirect:/posts");
                return modelAndView;
            } catch (PostException e) {
                log.error("Error while deleting post! "+e.getMessage());
                modelAndView = new ModelAndView("redirect:/error");
                redirectAttributes.addFlashAttribute("error", "Error while deleting post! " + e.getMessage());
                return modelAndView;
            }
        }
        log.warn("You need to login before sending delete request to /posts/delete/{postId} url!");
        modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }


    @PostMapping("/like/{postId}")
    public String togglePost(HttpSession session, @PathVariable Integer postId, @RequestParam("redirect_url") String redirect_url){
        Permission permission = new Permission();
        if(permission.isLoggedIn(session)){
            Profile profile = (Profile) session.getAttribute("current_user");
            if(profileService.isLiked(profile.getId(), postId)){
                postService.unlikePost(profile.getId(), postId);
                log.info("Post with id (" + postId + ") has unliked by " + profile.getUsername());
            }else{
                postService.likePost(profile.getId(), postId);
                log.info("Post with id (" + postId + ") has liked by " + profile.getUsername());
            }
            return (redirect_url != null) ? "redirect:"+redirect_url : "redirect:/posts";
        }
        log.warn("You need to login before sending post request to /posts/like/{postId} url!");
        return "redirect:/";
    }

}
