package com.hw2.blog.service;

import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.exception.PostException;
import com.hw2.blog.repo.PostRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @InjectMocks
    PostService postService;

    @Mock
    PostRepository postRepository;
    static Profile author;
    static List<Post> posts;
    static List<Post> liked_posts;

    @BeforeAll
    static void initData(){
        posts = new ArrayList<>();
        author = new Profile(1,"frasulov");
        Profile p1 = new Profile(2,"jhaciyev");

        Post post1 = new Post(1,author);
        Post post3 = new Post(2,p1);
        Post post4 = new Post(3,author);
        Post post2 = new Post(4,p1);
        Post post5 = new Post(5,author);

        posts.add(post1);
        posts.add(post3);
        posts.add(post4);
        posts.add(post2);
        posts.add(post5);

        liked_posts = new ArrayList<>(); liked_posts.add(post1); liked_posts.add(post4);
        author.setLiked_posts(liked_posts.stream().collect(Collectors.toSet()));
        // 3 author posts exist
    }

    @Test
    @DisplayName("Expect to get 3 posts for given author")
    void testGetPostByAuthor(){
        given(postRepository.getPostByAuthor(author)).willReturn(posts.stream().filter((post) -> post.getAuthor().equalsTo(author)).collect(Collectors.toList()));

        List<Post> author_posts = postService.getPostByAuthor(author);

        then(postRepository).should().getPostByAuthor(any(Profile.class));
        assertThat(author_posts).hasSize(3);

    }

    @Test
    @DisplayName("Expect to get 5 posts from result")
    void testGetAllPosts(){
        given(postRepository.findAll()).willReturn(posts);

        List<Post> allPosts = postService.getAllPosts();

        then(postRepository).should().findAll();
        assertThat(allPosts).hasSize(5);

    }


    @Test
    @DisplayName("Expect to get liked post")
    void testGetLikedPosts(){
        given(postRepository.getLikedPosts(anyInt())).willReturn(liked_posts);

        List<Post> allLikedPosts = postService.getLikedPosts(anyInt());

        then(postRepository).should().getLikedPosts(anyInt());
        assertThat(allLikedPosts).isEqualTo(liked_posts);

    }

    @Test
    @DisplayName("Expect to get 1 post with permission")
    void testGetPost() throws PostException {
        Post post = new Post(1, author);
        given(postRepository.findById(1)).willReturn(Optional.of(post));

        Post found = postService.getPost(1,author);

        then(postRepository).should().findById(1);
        assertThat(found).isNotNull().isInstanceOf(Post.class).isEqualTo(post);

    }

    @Test
    @DisplayName("Expect to get permission exception")
    void testGetPostException() {
        Post post = new Post(1, author);
        given(postRepository.findById(anyInt())).willReturn(Optional.of(post));

        assertThrows(PostException.class, () -> postService.getPost(anyInt(), new Profile(12, "frasulzada")));
    }

    @Test
    @DisplayName("Save Post Test")
    void testSavePost(){

        Post post = new Post(1, author);
        given(postRepository.save(post)).willReturn(post);

        Post saved_post = postService.savePost(post);

        then(postRepository).should().save(any(Post.class));
        assertThat(saved_post).isNotNull();
    }

}