package ada.wm2.firstsb.helper;

public class PatientHelper {

    public static Integer getPatientBirthYear(Integer patientAge) throws NullPointerException, IllegalArgumentException{
        if (patientAge == 0) {
            throw new IllegalArgumentException("Patient age can not be 0! ");
        }

        if (patientAge == null) {
            throw new NullPointerException("Patient age cannot be null. Specify the patient's age!");
        }


        Integer year = 2021;
        return year - patientAge;

    }



}
