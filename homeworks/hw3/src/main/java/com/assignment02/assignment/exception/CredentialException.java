package com.assignment02.assignment.exception;

public class CredentialException extends Exception {

    String errorDescription;

    public CredentialException(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
