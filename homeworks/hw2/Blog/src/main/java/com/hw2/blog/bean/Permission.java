package com.hw2.blog.bean;

import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.repo.PostRepository;
import com.hw2.blog.repo.ProfileRepository;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

public class Permission {

    ProfileService profileService;

    public Permission(ProfileService profileService) {
        this.profileService = profileService;
    }

    public Permission(){

    }

    public boolean hasPermission(Profile current_profile, Profile post_profile){
        return current_profile.equalsTo(post_profile);
    }

    public boolean isLiked(Integer profile_id, Integer post_id){
        Boolean result = profileService.isLiked(profile_id, post_id);
        System.out.println("Profile(" + profile_id + ") is liked Post("+post_id +"): "+result);
        return result;
    }

    public boolean isLoggedIn(HttpSession session){
        Profile profile = (Profile) session.getAttribute("current_user");
        return (profile != null);
    }

    public List<Profile> getProfiles(Integer post_id){
        return profileService.profilesLikedPost(post_id);
    }

}
