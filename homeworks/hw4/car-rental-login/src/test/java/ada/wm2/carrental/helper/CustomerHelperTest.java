package ada.wm2.carrental.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerHelperTest
{

    @Test
    @DisplayName("checkAge() function")
    void testCheckAge()
    {
        Integer age = 21;
        Boolean expected = true;

        Boolean result = CustomerHelper.checkAge(age);
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("checkAge() function null exception")
    void testCheckAgeNull()
    {
        Integer age = null;
        assertThrows(NullPointerException.class, () -> CustomerHelper.checkAge(age));
    }

    @Test
    @DisplayName("checkAge() function argument exception")
    void testCheckAgeArgument()
    {
        Integer age = -1;
        assertThrows(IllegalArgumentException.class, () -> CustomerHelper.checkAge(age));
    }
}
