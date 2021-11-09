package com.example.creator.part2;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Coffee {

    private final EspressoBean espressoBeans;
    private final int waterAmount;
    private String name;

    public Coffee(EspressoBean espressoBeans, int waterAmount) {
        this(espressoBeans, waterAmount, null);
    }

    public Coffee(EspressoBean espressoBeans, int waterAmount, String name) {
        this.espressoBeans = espressoBeans;
        this.waterAmount = waterAmount;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
