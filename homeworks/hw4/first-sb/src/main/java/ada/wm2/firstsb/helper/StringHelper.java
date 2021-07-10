package ada.wm2.firstsb.helper;




public class StringHelper {
    public static String reverse(String str) throws NullPointerException, IllegalArgumentException{
        if (str == null)
            throw new NullPointerException("String cannot be empty!");
        if (str.length() == 0)
            throw new IllegalArgumentException("String cannot be empty!");

        String retVal = "";
        for (int i=str.length()-1; i>=0; i--) {
            retVal += str.charAt(i);
        }
        return retVal;
    }
}
