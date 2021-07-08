package com.hw2.blog.exception;

public class PostException extends Exception{

    public PostException(String message) {
        super(message);
    }

    public PostException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostException() {
    }
}
