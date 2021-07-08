package com.assignment02.assignment.helper;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerHelperTest {

    @Test
    @DisplayName("Age is valid")
    void testBirthYear() {
        Integer age = 21;
        Integer expected = 2000;
        Integer result = PlayerHelper.getBirthYear(age);

        assertEquals(result, expected);
    }

    @Test
    @DisplayName("Age is null")
    void testBirthYearNullPointerException() {
        Integer age = null;

        assertThrows(NullPointerException.class, () -> PlayerHelper.getBirthYear(age));
    }

    @Test
    @DisplayName("Age is out of the accepted range")
    void testBirthYearIllegalArgumentException() {
        Integer age = 14;

        assertThrows(IllegalArgumentException.class, () -> PlayerHelper.getBirthYear(age));
    }
}