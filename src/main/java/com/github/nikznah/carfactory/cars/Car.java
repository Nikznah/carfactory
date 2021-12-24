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

    public int CalculateFullPrice() {
        System.out.println("Ваш заказ " + getBrand() + " базовая стоимость:" + price
                + "\nТип двигателя:" + getTypeEngine());
        int fullPrice = price + CalculatePriceColor()
                + CalculatePriceEnginePower()
                + CalculatePriceAdditionalOptions();
        System.out.println("Полная стоимость автомобиля:" + fullPrice);
        System.out.println("____________________________");
        return fullPrice;
    }

    private int CalculatePriceEnginePower() {
        if (getEnginePower() < 0) {
            throw new IllegalArgumentException("Неверное значение мощности двигателя!");
        }
        int temp;
        if (getEnginePower() <= 100) {
            temp = 0;
        } else if (getEnginePower() > 100 && getEnginePower() < 150) {
            temp = 30_000;
        } else if (getEnginePower() >= 150 && getEnginePower() < 250) {
            temp = 80_000;
        } else {
            temp = 120_000;
        }
        System.out.println("Мощность двигателя: " + getEnginePower() + "л.с Цена:" + temp);
        return temp;
    }

    private int CalculatePriceColor() {
        if (getColor().equals(COLOR.RED)) {
            System.out.println("Цвет: " + COLOR.RED + " Цена:" + COLOR.RED.getPrice());
            return COLOR.RED.getPrice();
        } else if (COLOR.BLUE.equals(getColor())) {
            System.out.println("Цвет: " + COLOR.BLUE);
            return COLOR.BLUE.getPrice();
        } else if (COLOR.GREEN.equals(getColor())) {
            System.out.println("Цвет: " + COLOR.GREEN);
            return COLOR.GREEN.getPrice();
        } else {
            throw new IllegalArgumentException("Цвет: " + getColor() + " не найден");
        }
    }

    public abstract int CalculatePriceAdditionalOptions();


}
