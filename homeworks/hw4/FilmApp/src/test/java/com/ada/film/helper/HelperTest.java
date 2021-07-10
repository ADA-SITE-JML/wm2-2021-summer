package com.ada.film.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelperTest {

    @Test
    @DisplayName("TestDateFormat")
    void changeString() throws Exception {
        String name = "El2vina Isma4yilov0a1";
        String expected_name = "Elvina Ismayilova";

        String result = HelperClass.changeString(name);
        assertEquals(expected_name,result);
    }

    @Test
    void changeStringTestException() {
        String name = "";

        assertThrows(Exception.class, () -> HelperClass.changeString(name));
    }

}
