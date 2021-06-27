package com.hw2.blog.exception;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ProfileException extends Exception {

    private String field;

    public ProfileException() {
        super();
    }

    public ProfileException(String message) {
        super(message);
    }
    public ProfileException(String field, String message) {
        super(message);
        this.field = field;
    }


    public FieldError getFieldError() {
        return new FieldError("profile", field, super.getMessage());
    }


}
