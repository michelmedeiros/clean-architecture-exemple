package br.com.clean.architecture.example.exceptions;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends Exception {

    private BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "BusinessException: "+ getMessage();
    }

}