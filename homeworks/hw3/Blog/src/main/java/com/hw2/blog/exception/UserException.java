package com.hw2.blog.exception;

import org.springframework.validation.FieldError;

public class UserException extends Exception{

    private String field;

    public UserException(String field) {
        this.field = field;
    }

    public UserException(String field, String message) {
        super(message);
        this.field = field;
    }

    public UserException(String field, String message, Throwable cause) {
        super(message, cause);
        this.field = field;
    }

    public FieldError getFieldError(){
        return new FieldError("user", field, super.getMessage());
    }
}
