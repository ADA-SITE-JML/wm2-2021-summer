package ada.wm2.firstsb.helper;

public class DoctorHelper {
    public static String getDoctorShift(Integer doctorId) throws NullPointerException, IllegalArgumentException {

        if (doctorId == 0)
            throw new IllegalArgumentException("Doctor ID cannot be zero!");


        if (doctorId < 0) {
            throw new NullPointerException("ID cannot be negative value!");
        }

        if (doctorId == null) {
            throw new NullPointerException("ID cannot be null. Specify the doctor's Id!");
        }




        String doctorShift = "";
        if (doctorId % 2 == 0)
            doctorShift = "morning"; // all doctors with even ID will work on morning shift
        if (doctorId % 2 == 1)
            doctorShift = "night";   // all doctors with odd ID will work on night shift
        return  doctorShift;

    }
}
