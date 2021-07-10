package ada.wm2.libraryapp.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonHelperTest {

    @Test
    @DisplayName("Gender only with F or M")
    void testException() {
        String gender = "Femanle";

        assertThrows(IllegalArgumentException.class, ()->PersonHelper.containsFOrMLetter(gender));

    }

    @Test
    @DisplayName("Expected gender format")
    void testFOrMLetter(){

        String expected_gender = "F";
        String result  = PersonHelper.containsFOrMLetter(expected_gender);


        assertEquals(expected_gender,result);


    }
}
