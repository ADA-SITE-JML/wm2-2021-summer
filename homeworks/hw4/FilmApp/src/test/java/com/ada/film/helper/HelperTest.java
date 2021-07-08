package com.ada.film.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelperTest {

    @Test
    @DisplayName("TestDateFormat")
    void DateFormat() throws Exception {
        String date = "10.07.2021";
        String expected_date = "2021-07-10";

        String result = DateConverter.DateFormat(date);
        assertEquals(expected_date,result);
    }

    @Test
    void DateFormatTestException() {
        String date = "wrondinput";

        assertThrows(Exception.class, () -> DateConverter.DateFormat(date));
    }

}
