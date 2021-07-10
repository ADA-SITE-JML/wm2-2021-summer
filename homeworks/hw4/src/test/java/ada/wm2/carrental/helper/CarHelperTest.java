package ada.wm2.carrental.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarHelperTest
{

    @Test
    @DisplayName("getCarAge() function")
    void testGetCarAge()
    {
        Integer year = 2014;
        Integer expected = 7;

        Integer result = CarHelper.getCarAge(year);
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("getCarAge() null exception")
    void testGetCarAgeNull()
    {
        Integer year = null;
        assertThrows(NullPointerException.class, () -> CarHelper.getCarAge(year));
    }

    @Test
    @DisplayName("getCarAge() illegal argument exception")
    void testGetCarAgeArgument()
    {
        Integer year = -1;
        assertThrows(IllegalArgumentException.class, () -> CarHelper.getCarAge(year));
    }
}
