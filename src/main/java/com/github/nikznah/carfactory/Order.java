package com.github.nikznah.carfactory;

import com.github.nikznah.carfactory.cars.Car;
import com.github.nikznah.carfactory.cars.brands.Audi;
import com.github.nikznah.carfactory.cars.brands.BMW;
import com.github.nikznah.carfactory.cars.brands.Volvo;
import lombok.Data;

import java.util.ArrayList;


@Data
public class Order {

    private int orderNumber;
    private static ArrayList<Car> cars;

    public static Car initialize(String brand, String color, int enginePower, String type, boolean a1, boolean a2) {
        Car.COLOR tmp;
        Car.TYPE_ENGINE tmp2;

        if (color.equals(Car.COLOR.RED.toString())) {
            tmp = Car.COLOR.RED;
        } else if (color.equals(Car.COLOR.GREEN.toString())) {
            tmp = Car.COLOR.GREEN;
        } else if (color.equals(Car.COLOR.BLUE.toString())) {
            tmp = Car.COLOR.BLUE;
        } else {
            throw new IllegalArgumentException("Данного цвета нет в базе данных! " + color);
        }

        if (type.equals(Car.TYPE_ENGINE.V8.toString())) {
            tmp2 = Car.TYPE_ENGINE.V8;
        } else if (type.equals(Car.TYPE_ENGINE.V12.toString())) {
            tmp2 = Car.TYPE_ENGINE.V12;
        } else {
            throw new IllegalArgumentException("Данный тип двигателя отсутствует! " + type);
        }

        if (brand.equals(Car.BRANDS.BMW.toString())) {
            return new BMW(brand, tmp, enginePower, tmp2, a1, a2);
        } else if (brand.equals(Car.BRANDS.Volvo.toString())) {
            return new Volvo(brand, tmp, enginePower, tmp2, a1, a2);
        } else if (brand.equals(Car.BRANDS.Audi.toString())) {
            return new Audi(brand, tmp, enginePower, tmp2, a1, a2);
        } else {
            throw new IllegalArgumentException("Ошибка! данная марка автомабиля, не продается!");
        }
    }

    public void putOrder(String brand, String color, int enginePower, String type, boolean a1, boolean a2) {
        orderNumber = 1;
        cars.add(initialize(brand, color, enginePower, type, a1, a2));
    }


}
