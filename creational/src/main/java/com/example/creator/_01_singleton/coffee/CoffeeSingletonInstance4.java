package com.example.creator._01_singleton.coffee;

public class CoffeeSingletonInstance4 {
    private CoffeeSingletonInstance4() {
    }
    public static class CoffeeSingletonInstance4Holder {
        private static final CoffeeSingletonInstance4 INSTANCE = new CoffeeSingletonInstance4();
    }
    public static CoffeeSingletonInstance4 getInstance() {
        return CoffeeSingletonInstance4Holder.INSTANCE;
    }
}
