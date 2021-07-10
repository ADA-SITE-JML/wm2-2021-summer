package ada.wm2.carrental.helper;

public class CustomerHelper {

    public static Boolean checkAge(Integer age) {
        if (age == null)
            throw new NullPointerException("Age cannot be null!");
        if (age < 18)
            throw new IllegalArgumentException("Below the legal age");
        return true;
    }
}
