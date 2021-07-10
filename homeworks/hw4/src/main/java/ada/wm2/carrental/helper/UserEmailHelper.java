package ada.wm2.carrental.helper;

public class UserEmailHelper {

    public static Boolean checkEmail(String email) {
        if (email == null)
            throw new NullPointerException("String cannot be empty!");
        if (email.length() < 4)
            throw new IllegalArgumentException("Email length cannot be less than 4!");
        return email.contains("@");
    }
}
