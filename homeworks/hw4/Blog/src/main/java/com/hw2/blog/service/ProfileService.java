package com.hw2.blog.service;

import com.hw2.blog.entity.Profile;
import com.hw2.blog.entity.User;
import com.hw2.blog.exception.ProfileException;
import com.hw2.blog.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public boolean isUserExist(User user, String username, String password){
        Optional<Profile> p = profileRepository.findByUserAndUsernameAndPassword(user, username, password);
        if (p.isPresent()){
            return true;
        }
        return false;

    }

    public Profile getByNameAndSurname(String username, String password){
        Optional<Profile> p = profileRepository.findByUsernameAndPassword(username, password);
        return p.get();
    }

    public Profile getPostById(Integer profileId) {
        Optional<Profile> profile = profileRepository.findById(profileId);
        if(profile.isPresent()){
            return profile.get();
        }
        return new Profile();
    }

    public List<Profile> profilesLikedPost(Integer post_id){
        List<Profile> profiles = (List<Profile>) profileRepository.getProfilesWhoLikedPost(post_id);
        return profiles;
    }

    public Boolean isLiked(Integer profile_id, Integer post_id) {
        return profileRepository.checkProfileLikedPost(profile_id, post_id);

    }


    public Profile saveProfile(Profile profile) throws ProfileException, Exception{

        String password = profile.getPassword();
        String username = profile.getUsername();
        if (password.equalsIgnoreCase(username)){
            throw new ProfileException("password", "Username cannot be same with password!");
        }else{
            String tokens [] = profile.getFullname().split(" ");
            if(tokens.length < 2)
                throw new ProfileException("fullname", "Please, write your fullname with space!");
        }

        return profileRepository.save(profile);
    }

    public void deleteProfile(Integer profileId){
        profileRepository.deleteById(profileId);
    }
}
