package com.github.nikznah.carfactory.cars;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public abstract class Car {

    private final String brand;
    private final COLOR color;
    private final int enginePower;
    @Setter
    private int price;
    private final TYPE_ENGINE typeEngine;
    private final boolean additionalOption1;
    private final boolean additionalOption2;


    public Car(String brand, COLOR color, int enginePower, TYPE_ENGINE typeEngine, boolean additionalOption1, boolean additionalOption2) {
        this.brand = brand;
        this.color = color;
        this.enginePower = enginePower;
        this.typeEngine = typeEngine;
        this.additionalOption1 = additionalOption1;
        this.additionalOption2 = additionalOption2;
    }



    @Getter
    @RequiredArgsConstructor
    public enum COLOR {
        RED(0),
        GREEN(50_000),
        BLUE(20_000);

        private final int price;
    }

    @Getter
    public enum TYPE_ENGINE {
        V8,
        V12
    }

    @Getter
    public enum BRANDS {
        BMW,
        Audi,
        Volvo
    }


}
