package com.example.behavioural._19_observer._03_java;

public class MyEvent {

    private final String message;

    public MyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
