package ada.wm2.carrental.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserEmailHelperTest
{

    @Test
    @DisplayName("checkEmail() function")
    void testCheckEmail()
    {
        String email = "nuray@mail.com";
        Boolean expected = true;

        Boolean result = UserEmailHelper.checkEmail(email);
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("checkEmail() function returns false")
    void testCheckEmailFalse()
    {
        String email = "mail.com";
        Boolean expected = false;

        Boolean result = UserEmailHelper.checkEmail(email);
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("checkEmail() function null exception")
    void testCheckEmailNull()
    {
        String email = null;
        assertThrows(NullPointerException.class, () -> UserEmailHelper.checkEmail(email));
    }

    @Test
    @DisplayName("checkEmail() function argument exception")
    void testCheckEmailArgument()
    {
        String email = "a";
        assertThrows(IllegalArgumentException.class, () -> UserEmailHelper.checkEmail(email));
    }
}
