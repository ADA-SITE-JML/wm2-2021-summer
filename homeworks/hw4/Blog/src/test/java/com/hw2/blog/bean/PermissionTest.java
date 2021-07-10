package com.hw2.blog.bean;

import com.hw2.blog.entity.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionTest {

    Permission permission;
    MockHttpSession session;
    Profile profile;

    @BeforeEach
    void setUp(){
        permission = new Permission();
        profile = new Profile("frasulov");
        session = new MockHttpSession();
        session.setAttribute("current_user", profile);
    }

    @Test
    @DisplayName("Test User Permission")
    void testHasPermission(){
        Profile profile1 = new Profile("frasulov");
        boolean result = permission.hasPermission(profile1, profile);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Test User logged in")
    void testIsLoggedIn(){
        Profile p = (Profile) session.getAttribute("current_user");
        assertNotEquals(null, p);
    }

    @Test
    @DisplayName("Test Converting Date")
    void testChangeDateFormat(){
        Timestamp given = new Timestamp(1625905254498L); // 2021-07-10 12:20:54
        String expected = "July 10, 2021 12:20:54";
        String result = permission.changeDateFormat(given);
        System.out.println(result);
        assertEquals(expected, result);

    }

}
