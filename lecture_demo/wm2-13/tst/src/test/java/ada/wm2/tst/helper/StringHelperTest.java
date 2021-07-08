package ada.wm2.tst.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    @DisplayName("String reverse function")
    void testReverse() {
        String text = "salam";
        String expected = "malas";

        String result = StringHelper.reverse(text);
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("String reverse exceptions")
    void testReverseException() {
        String text = "";

        assertThrows(IllegalArgumentException.class,()->StringHelper.reverse(text));
    }

}