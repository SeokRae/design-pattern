package com.example.creator._01_singleton.coffee;

public class CoffeeSingletonInstance1 {
    private static CoffeeSingletonInstance1 instance;
    private CoffeeSingletonInstance1() {}

    public static CoffeeSingletonInstance1 getInstance() {
        if(instance == null) {
            instance = new CoffeeSingletonInstance1();
        }
        return instance;
    }
}
