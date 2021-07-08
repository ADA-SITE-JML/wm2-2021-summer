package com.assignment02.assignment.helper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamHelperTest {

    @Test
    @DisplayName("Team age is valid")
    void testTeamAge() {
        Integer estYear = 1905;
        Integer expected = 116;
        Integer result = TeamHelper.getTeamAge(estYear);

        assertEquals(result, expected);
    }

    @Test
    @DisplayName("Team age is null")
    void testTeamAgeNullPointerException() {
        Integer estYear = null;

        assertThrows(NullPointerException.class, () -> TeamHelper.getTeamAge(estYear));
    }

    @Test
    @DisplayName("Team age is in illegal range")
    void testTeamAgeIllegalArgumentException() {
        Integer estYear = 1799;

        assertThrows(IllegalArgumentException.class, () -> TeamHelper.getTeamAge(estYear));
    }
}