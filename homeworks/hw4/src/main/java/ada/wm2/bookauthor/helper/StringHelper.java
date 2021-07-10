package ada.wm2.bookauthor.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    public static boolean isEmail(String email) throws NullPointerException, IllegalArgumentException{
        if (email == null)
            throw new NullPointerException("String cannot be empty!");
        if (email.length() == 0)
            throw new IllegalArgumentException("String cannot be empty!");

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
