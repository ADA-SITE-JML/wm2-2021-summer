package ada.wm2.firstsb.Helper;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringHelperTest {

    @Test
    @DisplayName("String reverse function")
    void testReverse() {
        String text = "gamer";
        String expected = "remag";

        String result = ada.wm2.firstsb.helper.StringHelperTest.reverse(text);
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("String reverse exceptions")
    void testReverseException() {
        String text = "";

        assertThrows(IllegalArgumentException.class,()-> ada.wm2.firstsb.helper.StringHelperTest.reverse(text));
    }

}

