package ada.wm2.firstsb.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientHelperTest {


    @Test
    @DisplayName("the patient birth year has been entered correctly")
    void testGetPatientBirthYear() {
        Integer patientAge = 23;
        Integer expected = 1998;

        Integer result = PatientHelper.getPatientBirthYear(patientAge);
        assertEquals(expected,result);
    }



    @Test
    @DisplayName("getPatientBirthYear exceptions")
    void testGetPatientBirthYearIllegalArgument() {
        Integer patientAge = 0;

        assertThrows(IllegalArgumentException.class,()->PatientHelper.getPatientBirthYear(patientAge));
    }

    @Test
    @DisplayName("getPatientBirthYear null argument exceptions")
    void testGetPatientBirthYearException() {
        Integer patientAge = null ;

        assertThrows(NullPointerException.class,()->PatientHelper.getPatientBirthYear(patientAge));
    }




}