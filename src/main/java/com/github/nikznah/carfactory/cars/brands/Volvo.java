package com.github.nikznah.carfactory.cars.brands;

import com.github.nikznah.carfactory.cars.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Volvo extends Car {

    private static final int PRICE_VOLVO = 1_300_000;

    @Getter
    @RequiredArgsConstructor
    private enum AdditionalOptions {
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


    @Override
    public int CalculatePriceAdditionalOptions() {
        if (isAdditionalOption1() && isAdditionalOption2()) {
            System.out.printf("%s цена: %s\n%s цена: %s\n", AdditionalOptions.carChildSeat.name,
                    AdditionalOptions.carChildSeat.price,
                    AdditionalOptions.antiReflectiveMirrors.name,
                    AdditionalOptions.antiReflectiveMirrors.price);
            return AdditionalOptions.carChildSeat.price + AdditionalOptions.antiReflectiveMirrors.price;
        } else if (isAdditionalOption1()) {
            System.out.printf("%s цена: %s\n", AdditionalOptions.carChildSeat.name,
                    AdditionalOptions.carChildSeat.price);
            return AdditionalOptions.carChildSeat.price;
        } else if (isAdditionalOption2()) {
            System.out.printf("%s цена: %s\n", AdditionalOptions.antiReflectiveMirrors.name,
                    AdditionalOptions.antiReflectiveMirrors.price);
            return AdditionalOptions.antiReflectiveMirrors.price;
        } else {
            return 0;
        }
    }
}
