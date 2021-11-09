package com.example.creator.part2;

public class Americano extends Coffee {
    public Americano(EspressoBean espressoBeans, int waterAmount) {
        super(espressoBeans, waterAmount);
        setName("아메리카노 커피");
    }
}
