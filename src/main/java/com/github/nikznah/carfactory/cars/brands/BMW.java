package com.github.nikznah.carfactory.cars.brands;

import com.github.nikznah.carfactory.cars.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class BMW extends Car {

    @Getter
    private static final int PRICE_BMW = 1_200_000;

    @Getter
    @RequiredArgsConstructor
    public enum AdditionalOptions {
        MEquipment("наличие M пакета ", 600_000),
        airSuspension("наличие пневматической подвески", 150_000);

        private final String name;
        private final int price;

    }

    public BMW(String brand, COLOR color, int enginePower,
               TYPE_ENGINE typeEngine, boolean additionalOption1, boolean additionalOption2) {
        super(brand, color, enginePower, typeEngine, additionalOption1, additionalOption2);
        setPrice(PRICE_BMW);
    }

}
