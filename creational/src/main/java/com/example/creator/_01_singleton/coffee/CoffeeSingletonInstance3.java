package com.example.creator._01_singleton.coffee;

public class CoffeeSingletonInstance3 {
    private static volatile CoffeeSingletonInstance3 instance;
    private CoffeeSingletonInstance3() {}

    public static CoffeeSingletonInstance3 getInstance() {
        if(instance == null) {
            synchronized (CoffeeSingletonInstance3.class) {
                if(instance == null) {
                    instance = new CoffeeSingletonInstance3();
                }
            }
        }
        return instance;
    }
}
