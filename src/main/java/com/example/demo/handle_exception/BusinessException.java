package com.example.demo.handle_exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}