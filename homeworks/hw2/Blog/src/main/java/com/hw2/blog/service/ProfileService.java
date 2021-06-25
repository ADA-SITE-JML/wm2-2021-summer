package com.hw2.blog.service;

import com.hw2.blog.entity.Profile;
import com.hw2.blog.repo.ProfileRepository;
import org.hibernate.UnknownEntityTypeException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public boolean isUserExist(String username, String password){
        Optional<Profile> p = profileRepository.findByUsernameAndPassword(username, password);
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


    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteProfile(Integer profileId){
        profileRepository.deleteById(profileId);
    }
}
