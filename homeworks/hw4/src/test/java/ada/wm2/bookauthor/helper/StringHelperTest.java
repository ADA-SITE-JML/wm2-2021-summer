package ada.wm2.bookauthor.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    @DisplayName("Is it an email?")
    void isEmail() {
        String email = "elnurabdullayev1997@gmail.com";
        Boolean expected = true;

        Boolean result = StringHelper.isEmail(email);
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("String email exceptions")
    void testIsEmailException() {
        String email = "";

        assertThrows(IllegalArgumentException.class,()->StringHelper.isEmail(email));
    }
}