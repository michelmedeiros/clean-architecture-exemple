package br.com.clean.architecture.example.exceptions;

public class InvalidEncryptException extends Exception {

    private InvalidEncryptException() {
    }

    public InvalidEncryptException(String message, Throwable cause) {
        super(String.join("-", message, cause.getMessage()));
    }




}
