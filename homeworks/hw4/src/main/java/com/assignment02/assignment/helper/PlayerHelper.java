package com.assignment02.assignment.helper;

import java.time.LocalDate;

public class PlayerHelper {

    public static Integer getBirthYear(Integer age) {
        if (age == null) {
            throw new NullPointerException("Age cannot be null");
        } else if (age < 15) {
            throw new IllegalArgumentException("Age cannot be less that 15");
        }

        Integer currentYear = 2021;
        return currentYear - age;
    }
}
