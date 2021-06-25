package com.hw2.blog.service;


import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getPostByAuthor(Profile author){
        List<Post> blog_list = (List<Post>) postRepository.getPostByAuthor(author);
        return blog_list;
    }

    public List<Post> getLikedPosts(Integer profile_id){
        return (List<Post>) postRepository.getLikedPosts(profile_id);
    }

    public List<Post> getAllPosts(){
        return (List<Post>) postRepository.findAll();
    }

    public Post savePost(Post post) {
        Post pst = postRepository.save(post);
        return pst;
    }

    public Optional<Post> getPost(Integer postId) {
        return postRepository.findById(postId);
    }

    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }


    public void unlikePost(Integer profile_id, Integer post_id){
        postRepository.deleteFromProfileLikedPosts(profile_id, post_id);
    }

    public void likePost(Integer profile_id, Integer post_id){
        postRepository.addToProfileLikedPosts(post_id, profile_id);
    }

}
