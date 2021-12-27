package com.github.nikznah.carfactory.calc;

import com.github.nikznah.carfactory.cars.brands.BMW;
import com.github.nikznah.carfactory.cars.brands.Volvo;

import static com.github.nikznah.carfactory.cars.Car.BRANDS;
import static com.github.nikznah.carfactory.cars.Car.COLOR;
import static com.github.nikznah.carfactory.cars.brands.Audi.AdditionalOptions.fogLights;
import static com.github.nikznah.carfactory.cars.brands.Audi.AdditionalOptions.molding;
import static com.github.nikznah.carfactory.cars.brands.BMW.AdditionalOptions.MEquipment;
import static com.github.nikznah.carfactory.cars.brands.BMW.AdditionalOptions.airSuspension;
import static com.github.nikznah.carfactory.cars.brands.Volvo.AdditionalOptions.antiReflectiveMirrors;
import static com.github.nikznah.carfactory.cars.brands.Volvo.AdditionalOptions.carChildSeat;

public class Calculator {

    public int CalculateFullPrice(String brand, String color, int enginePower, String type, boolean a1, boolean a2) {
        int basePrice;
        int additional;

        System.out.println("Ваш заказ " + brand + "\nТип двигателя:" + type);
        if (brand.equals(BRANDS.BMW.toString())) {
            basePrice = BMW.getPRICE_BMW();
            System.out.println("Базовая цена:" + basePrice);
            additional = CalculatePriceAdditionalOptionsBMW(a1, a2);
        } else if (brand.equals(BRANDS.Volvo.toString())) {
            basePrice = Volvo.getPRICE_VOLVO();
            System.out.println("Базовая цена:" + basePrice);
            additional = CalculatePriceAdditionalOptionsVolvo(a1, a2);
        } else if (brand.equals(BRANDS.Audi.toString())) {
            basePrice = Volvo.getPRICE_VOLVO();
            System.out.println("Базовая цена:" + basePrice);
            additional = CalculatePriceAdditionalOptionsAudi(a1, a2);
        } else {
            throw new IllegalArgumentException("Марка не найдена!");
        }
        int fullPrice = basePrice + CalculatePriceColor(color)
                + CalculatePriceEnginePower(enginePower)
                + additional;
        System.out.println("Полная стоимость автомобиля:" + fullPrice);
        System.out.println("____________________________");
        return fullPrice;
    }

    private int CalculatePriceEnginePower(int enp) {
        if (enp < 0) {
            throw new IllegalArgumentException("Неверное значение мощности двигателя!");
        }
        int temp;
        if (enp <= 100) {
            temp = 0;
        } else if (enp < 150) {
            temp = 30_000;
        } else if (enp < 250) {
            temp = 80_000;
        } else {
            temp = 120_000;
        }
        System.out.println("Мощность двигателя: " + enp + "л.с Цена:" + temp);
        return temp;
    }

    private int CalculatePriceColor(String color) {
        if (color.equals(COLOR.RED.toString())) {
            System.out.println("Цвет: " + COLOR.RED + " Цена:" + COLOR.RED.getPrice());
            return COLOR.RED.getPrice();
        } else if (color.equals(COLOR.BLUE.toString())) {
            System.out.println("Цвет: " + COLOR.BLUE + " Цена:" + COLOR.BLUE.getPrice());
            return COLOR.BLUE.getPrice();
        } else if (color.equals(COLOR.GREEN.toString())) {
            System.out.println("Цвет: " + COLOR.GREEN + " Цена:" + COLOR.GREEN.getPrice());
            return COLOR.GREEN.getPrice();
        } else {
            throw new IllegalArgumentException("Цвет: " + color + " не найден");
        }
    }

    private int CalculatePriceAdditionalOptionsBMW(boolean a1, boolean a2) {
        if (a1 && a2) {
            System.out.printf("%s цена: %s\n%s цена: %s\n", MEquipment.getName(),
                    MEquipment.getPrice(),
                    airSuspension.getName(),
                    airSuspension.getPrice());
            return MEquipment.getPrice() + airSuspension.getPrice();
        } else if (a1) {
            System.out.printf("%s цена: %s\n", MEquipment.getName(),
                    MEquipment.getPrice());
            return MEquipment.getPrice();
        } else if (a2) {
            System.out.printf("%s цена: %s\n", airSuspension.getName(),
                    airSuspension.getPrice());
            return airSuspension.getPrice();
        } else {
            return 0;
        }
    }

    private int CalculatePriceAdditionalOptionsAudi(boolean a1, boolean a2) {
        if (a1 && a2) {
            System.out.printf("%s цена: %s\n%s цена: %s\n", molding.getName(),
                    molding.getPrice(),
                    fogLights.getName(),
                    fogLights.getPrice());
            return molding.getPrice() + fogLights.getPrice();
        } else if (a1) {
            System.out.printf("%s цена: %s\n", molding.getName(),
                    molding.getPrice());
            return molding.getPrice();
        } else if (a2) {
            System.out.printf("%s цена: %s\n", fogLights.getName(),
                    fogLights.getPrice());
            return fogLights.getPrice();
        } else {
            return 0;
        }
    }

    private int CalculatePriceAdditionalOptionsVolvo(boolean a1, boolean a2) {
        if (a1 && a2) {
            System.out.printf("%s цена: %s\n%s цена: %s\n", carChildSeat.getName(),
                    carChildSeat.getPrice(),
                    antiReflectiveMirrors.getName(),
                    antiReflectiveMirrors.getPrice());
            return carChildSeat.getPrice() + antiReflectiveMirrors.getPrice();
        } else if (a1) {
            System.out.printf("%s цена: %s\n", carChildSeat.getName(),
                    carChildSeat.getPrice());
            return carChildSeat.getPrice();
        } else if (a2) {
            System.out.printf("%s цена: %s\n", antiReflectiveMirrors.getName(),
                    antiReflectiveMirrors.getPrice());
            return antiReflectiveMirrors.getPrice();
        } else {
            return 0;
        }
    }
}
