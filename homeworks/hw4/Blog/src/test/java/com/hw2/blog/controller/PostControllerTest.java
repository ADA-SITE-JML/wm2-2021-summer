package com.hw2.blog.controller;


import com.hw2.blog.entity.Post;
import com.hw2.blog.entity.Profile;
import com.hw2.blog.service.PostService;
import com.hw2.blog.service.ProfileService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Map;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Mock
    PostService postService;

    @Mock
    Map<String, Integer> model;

    @InjectMocks
    PostController postController;

    @Mock
    ProfileService profileService;

    MockMvc mockMvc;

    private static MockHttpSession session;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @BeforeAll
    static void init(){
        session = new MockHttpSession();
        session.setAttribute("current_user", new Profile(1, "frasulov"));
    }

    @Test
    @DisplayName("Get all students template")
    void testListPosts() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("current_user", new Profile(1, "frasulov"));
        mockMvc.perform(get("/posts").session(session))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("header", "url", "posts", "post", "permission"))
                .andExpect(view().name("posts/posts"));
    }

    @Test
    @DisplayName("Get all posts template without login")
    void testListPostsWithoutProfileLogin() throws Exception {
        mockMvc.perform(get("/posts"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @DisplayName("Test creating new post")
    void testCreatePostView() throws Exception{
        Post post = new Post();
        post.setId(1);
        post.setTitle("Testing Post");
        post.setBody("It is body with no error which means has more than 32 character. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores ducimus, enim excepturi iure iusto maiores, nemo nesciunt nobis obcaecati odio placeat praesentium. Illum in quia reiciendis! Facere harum maiores veritatis.");
        post.setImage("https://media.istockphoto.com/vectors/no-image-available-sign-vector-id922962354?k=6&m=922962354&s=612x612&w=0&h=_KKNzEwxMkutv-DtQ4f54yA5nc39Ojb_KPvoV__aHyU=");

        mockMvc.perform(post("/posts")
                .session(session)
                .flashAttr("post", post))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/posts"));
    }

    @Test
    @DisplayName("Test creating new post with Form Error")
    void testCreatePostViewFormError() throws Exception{
        Post post = new Post();
        post.setId(1);
        post.setTitle("Testing Post");
        post.setBody("It is body with no error");
        post.setImage("error because no link");

        mockMvc.perform(post("/posts")
                .session(session)
                .flashAttr("post", post))
                .andExpect(status().isOk())
                .andExpect(view().name("posts/posts"));
    }

    @Test
    @DisplayName("Test creating new post with No Profile login")
    void testCreatePostViewWithoutProfileLogin() throws Exception{
        Post post = new Post();
        post.setId(1);
        post.setTitle("Testing Post");
        post.setBody("It is body with no error which means has more than 32 character. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores ducimus, enim excepturi iure iusto maiores, nemo nesciunt nobis obcaecati odio placeat praesentium. Illum in quia reiciendis! Facere harum maiores veritatis.");
        post.setImage("https://media.istockphoto.com/vectors/no-image-available-sign-vector-id922962354?k=6&m=922962354&s=612x612&w=0&h=_KKNzEwxMkutv-DtQ4f54yA5nc39Ojb_KPvoV__aHyU=");

        mockMvc.perform(post("/posts")
                .flashAttr("post", post))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }


    @Test
    @DisplayName("Test like or unlike post")
    void testTogglePost() throws Exception{
        String redirect_url = "/posts/";
        mockMvc.perform(post("/posts/like/1")
            .param("redirect_url", redirect_url)
            .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:"+redirect_url));
    }

    @Test
    @DisplayName("Test like or unlike post without Profile Login")
    void testTogglePostWithoutProfileLogin() throws Exception{
        String redirect_url = "/posts/";
        mockMvc.perform(post("/posts/like/1")
                .param("redirect_url", redirect_url))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }


    @Test
    @DisplayName("Test deleting post")
    void testDeletePost() throws Exception{

        mockMvc.perform(delete("/posts/delete/1")
                    .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/posts"));
    }


}
