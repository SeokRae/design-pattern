package com.example.creator._02_factory_method;

public class Espresso extends Coffee {
    public Espresso(EspressoBean espressoBeans, int waterAmount) {
        super(espressoBeans, 0);
        setName("에소프레소 커피");
    }
}
