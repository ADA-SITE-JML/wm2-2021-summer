package com.hw2.blog.controller;

import com.hw2.blog.bean.Permission;
import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

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

        return "redirect:/";
    }

    @PostMapping("/new")
    public String createPostView(HttpSession session, Model model, Post post){
        Profile profile = (Profile) session.getAttribute("current_user");
        if (profile != null){
            post.setAuthor(profile);
            Post pst = postService.savePost(post);
            return "redirect:/posts/";
        }

        return "redirect:/";
    }


    @GetMapping("/edit/{postId}")
    public String editPostView(HttpSession session, Model model, @PathVariable Integer postId){
        Permission permission = new Permission();
        // check user is logged in
        if(permission.isLoggedIn(session)){
            // check user has permission to delete
            Optional<Post> pst = postService.getPost(postId);
            if (pst.isPresent()){
                if(permission.hasPermission((Profile) session.getAttribute("current_user"), pst.get().getAuthor())){
                    model.addAttribute("post", pst.get());
                    return "posts/edit_post";
                }else
                    model.addAttribute("error", "You do not have permission to edit this post");
            }else
                model.addAttribute("error", "The post does not exist");
            return "error";
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{postId}")
    public String editPost(HttpSession session, Model model, Post post, @PathVariable Integer postId){
            Permission permission = new Permission();
            // check user is logged in
            if(permission.isLoggedIn(session)){
                Profile profile = (Profile) session.getAttribute("current_user");
                Optional<Post> pst = postService.getPost(postId);
                if (pst.isPresent()){
                    if(pst.get().equalsTo(post)){
                        boolean is_there = profileService.isLiked(profile.getId(), postId);
                        post.setAuthor(profile);
                        postService.savePost(post);
                        if(is_there){
                            System.out.println("Da");
                            postService.likePost(profile.getId(), postId);
                        }
                        return "redirect:/posts";
                    }
                }
                model.addAttribute("error", "Error happens while editing!");
                return "error";
            }
            return "redirect:/";
    }


    @DeleteMapping("/delete/{postId}")
    public String deletePostView(HttpSession session, Model model, @PathVariable Integer postId){
        Permission permission = new Permission();
        // check user is logged in
        if(permission.isLoggedIn(session)){
            // check user has permission to delete
            Optional<Post> pst = postService.getPost(postId);
            if (pst.isPresent()){
                if(permission.hasPermission((Profile) session.getAttribute("current_user"), pst.get().getAuthor())){
                    postService.deletePost(postId);
                    return "redirect:/posts";
                }else
                    model.addAttribute("error", "You do not have permission to delete this post");
            }else
                model.addAttribute("error", "The post does not exist");
            return "error";
        }
        return "redirect:/";
    }


    @PostMapping("/like/{postId}")
    public String togglePost(HttpSession session, @PathVariable Integer postId, @RequestParam("redirect_url") String redirect_url){
        Permission permission = new Permission();
        if(permission.isLoggedIn(session)){
            Profile profile = (Profile) session.getAttribute("current_user");
            if(profileService.isLiked(profile.getId(), postId)){
                postService.unlikePost(profile.getId(), postId);
            }else{
                postService.likePost(profile.getId(), postId);
            }
            return (redirect_url != null) ? "redirect:"+redirect_url : "redirect:/posts";
        }

        return "redirect:/";
    }

}
