package com.example.creator._02_factory_method;

public class Americano extends Coffee {
    public Americano(EspressoBean espressoBeans, int waterAmount) {
        super(espressoBeans, waterAmount);
        setName("아메리카노 커피");
    }
}
