package com.github.nikznah.carfactory.cars.brands;

import com.github.nikznah.carfactory.cars.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Audi extends Car {

    @Getter
    private static final int PRICE_AUDI = 1_150_000;

    @Getter
    @RequiredArgsConstructor
    public enum AdditionalOptions {
        molding("Наличие фирменных молдингов ", 75_000),
        fogLights("Наличие противотуманок", 50_000);

        private final String name;
        private final int price;

    }

    public Audi(String brand, COLOR color, int enginePower, TYPE_ENGINE typeEngine,
                boolean additionalOption1, boolean additionalOption2) {
        super(brand, color, enginePower, typeEngine, additionalOption1, additionalOption2);
        setPrice(PRICE_AUDI);
    }
}
