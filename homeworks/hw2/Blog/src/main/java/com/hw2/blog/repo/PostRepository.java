package com.hw2.blog.repo;

import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {

    Iterable<Post> getPostByAuthor(Profile author);


    @Query(value = "select * from posts where id  in (select post_id from profile_liked_posts where profile_id=?);",
            nativeQuery = true)
    Iterable<Post> getLikedPosts(long profile_id);


    @Query(value = "select p from Post p where upper(p.title)=upper(?1)")
    Iterable<Post> searchPosts(String query);

    @Modifying
    @Transactional
    @Query(value = "delete from profile_liked_posts where profile_id=? and post_id=?", nativeQuery = true)
    void deleteFromProfileLikedPosts(Integer profile_id, Integer post_id);

    @Modifying
    @Transactional
    @Query(value = "insert into profile_liked_posts values (?, ?)", nativeQuery = true)
    void addToProfileLikedPosts(Integer post_id, Integer profile_id);

}
