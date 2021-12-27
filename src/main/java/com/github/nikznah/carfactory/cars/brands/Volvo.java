package com.github.nikznah.carfactory.cars.brands;

import com.github.nikznah.carfactory.cars.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Volvo extends Car {

    @Getter
    private static final int PRICE_VOLVO = 1_300_000;

    @Getter
    @RequiredArgsConstructor
    public enum AdditionalOptions {
        carChildSeat("Наличие детского сиденья", 95_000),
        antiReflectiveMirrors("Наличие антибликовых зеркал", 115_000);

        private final String name;
        private final int price;

    }

    public Volvo(String brand, COLOR color, int enginePower, TYPE_ENGINE typeEngine,
                 boolean additionalOption1, boolean additionalOption2) {
        super(brand, color, enginePower, typeEngine, additionalOption1, additionalOption2);
        setPrice(PRICE_VOLVO);
    }


}
