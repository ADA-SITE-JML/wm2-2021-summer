package com.assignment02.assignment.helper;

public class TeamHelper {

    public static Integer getTeamAge(Integer estYear) {
        if (estYear == null) {
            throw new NullPointerException("Establishment year cannot be null");
        } else if (estYear < 1800) {
            throw new IllegalArgumentException("Establishment year cannot be less than 1800");
        }

        Integer currentYear = 2021;
        return currentYear - estYear;
    }
}
