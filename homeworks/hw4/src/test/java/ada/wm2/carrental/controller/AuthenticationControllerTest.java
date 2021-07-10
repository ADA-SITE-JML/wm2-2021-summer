package ada.wm2.carrental.controller;

import ada.wm2.carrental.service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest
{

    @Mock
    AuthenticationService authenticationService;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    AuthenticationController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Should return login page")
    void testGetLoginPage() throws Exception
    {
        mockMvc.perform(get("/auth"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @DisplayName("Should return error")
    void testGetLoginPagePost() throws Exception
    {
        mockMvc.perform(post("/auth"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Should logout with redirect")
    void testLogout() throws Exception
    {
        mockMvc.perform(get("/auth/logout"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @DisplayName("Should login with redirect")
    void testLogin() throws Exception
    {
        mockMvc.perform(post("/auth/login?email=nuray@mail.com&password=123123123"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @DisplayName("Should return error")
    void testLoginGet() throws Exception
    {
        mockMvc.perform(get("/auth/login?email=nuray@mail.com&password=123123123"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Should register")
    void testRegister() throws Exception
    {
        mockMvc.perform(post("/auth/register?email=nuray@mail.com&password=123123123&name=nuray"))
                .andExpect(status().is3xxRedirection());
    }

}