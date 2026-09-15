package com.atguigu.java.day4.exception;

public class UserLoginFailedException extends RuntimeException{

    public UserLoginFailedException() {
    }

    public UserLoginFailedException(String message) {
        super(message);
    }

    public UserLoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginFailedException(Throwable cause) {
        super(cause);
    }
}
