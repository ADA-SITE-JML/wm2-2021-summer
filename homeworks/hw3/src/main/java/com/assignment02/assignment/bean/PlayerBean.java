package com.assignment02.assignment.bean;

import java.io.Serializable;

public class PlayerBean implements Serializable {

    String firstName;
    String lastName;
//    Integer age;
//    String club;
//    Integer goals;
//    Integer assists;

    public PlayerBean() {

    }

    public PlayerBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
