package com.example.creator._01_singleton.coffee;

public class CoffeeSingletonInstance2 {
    private static CoffeeSingletonInstance2 instance;
    private CoffeeSingletonInstance2() {}

    public static synchronized CoffeeSingletonInstance2 getInstance() {
        if(instance == null) {
            instance = new CoffeeSingletonInstance2();
        }
        return instance;
    }
}
