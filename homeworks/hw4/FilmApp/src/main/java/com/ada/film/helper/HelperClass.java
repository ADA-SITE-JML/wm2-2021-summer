package com.ada.film.helper;

public class HelperClass {

    public static String changeString(String old) throws Exception {
        if (old == null || old.length() == 0)
            throw new Exception("Invalid input");
        String nums [] = {"1", "2","3", "4", "5", "6", "7", "8", "9", "0"};

        for(String n: nums)
            old = old.replace(n, "");

        return old;

    }

}
