package com.github.nikznah.carfactory.cars.brands;

import com.github.nikznah.carfactory.cars.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class BMW extends Car {

    private static final int PRICE_BMW = 1_200_000;

    @Getter
    @RequiredArgsConstructor
    private enum AdditionalOptions {
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

    @Override
    public int CalculatePriceAdditionalOptions() {
        if (isAdditionalOption1() && isAdditionalOption2()) {
            System.out.printf("%s цена: %s\n%s цена: %s\n", AdditionalOptions.MEquipment.name,
                    AdditionalOptions.MEquipment.price,
                    AdditionalOptions.airSuspension.name,
                    AdditionalOptions.airSuspension.price);
            return AdditionalOptions.MEquipment.price + AdditionalOptions.airSuspension.price;
        } else if (isAdditionalOption1()) {
            System.out.printf("%s цена: %s\n", AdditionalOptions.MEquipment.name,
                    AdditionalOptions.MEquipment.price);
            return AdditionalOptions.MEquipment.price;
        } else if (isAdditionalOption2()) {
            System.out.printf("%s цена: %s\n", AdditionalOptions.airSuspension.name,
                    AdditionalOptions.airSuspension.price);
            return AdditionalOptions.airSuspension.price;
        } else {
            return 0;
        }
    }
}
