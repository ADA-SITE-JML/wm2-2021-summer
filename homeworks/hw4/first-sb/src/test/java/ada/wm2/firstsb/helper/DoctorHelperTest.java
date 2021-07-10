package ada.wm2.firstsb.helper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorHelperTest {

    @Test
    @DisplayName("Proper doctor shift (night)")
    void testGetDoctorShift() {
        Integer doctorId = 7;
        String expected = "night";


        String result = DoctorHelper.getDoctorShift(doctorId);
        assertEquals(expected,result);
    }


    @Test
    @DisplayName("Proper doctor shift (morning)")
    void testGetDoctorShiftForMorning() {
        Integer doctorId = 8;
        String expected = "morning";


        String result = DoctorHelper.getDoctorShift(doctorId);
        assertEquals(expected,result);
    }


    @Test
    @DisplayName("Doctor ID is not valid")
    void testGetDoctorShiftIllegalArgument() {
        Integer doctorId = 0;

        assertThrows(IllegalArgumentException.class,()->DoctorHelper.getDoctorShift(doctorId));
    }

    @Test
    @DisplayName("Doctor ID is not valid")
    void testGetDoctorShiftNullPointer() {
        Integer doctorId = null;

        assertThrows(NullPointerException.class,()->DoctorHelper.getDoctorShift(doctorId));
    }

}