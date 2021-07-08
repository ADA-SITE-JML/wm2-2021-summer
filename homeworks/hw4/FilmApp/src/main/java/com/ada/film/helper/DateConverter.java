package com.ada.film.helper;

public class DateConverter {

    public static String DateFormat(String old_format) throws Exception {

        String tokens [] = old_format.split("\\.");
        if (tokens.length !=3)
            throw new Exception("Wrong input");

        String new_format = tokens[2] + "-" + tokens[1] + "-" + tokens[0];

        return new_format;
    }

}
