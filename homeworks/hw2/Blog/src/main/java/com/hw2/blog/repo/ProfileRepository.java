package com.hw2.blog.repo;

import com.hw2.blog.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    Optional<Profile> findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from profiles where id in (select profile_id from profile_liked_posts where post_id = ?);", nativeQuery = true)
    Iterable<Profile> getProfilesWhoLikedPost(Integer post_id);


    @Query(value = "select case when count(*) = 1 then true else false end from profile_liked_posts where profile_id=? and post_id =?", nativeQuery = true)
    Boolean checkProfileLikedPost(Integer profile_id, Integer post_id);
}


