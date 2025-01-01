package com.example.socialMedia.exception;


public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String message) {
        super(message);
    }
}
