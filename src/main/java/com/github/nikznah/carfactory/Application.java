package com.github.nikznah.carfactory;

import com.github.nikznah.carfactory.cars.Car;
import com.github.nikznah.carfactory.cars.brands.Audi;
import com.github.nikznah.carfactory.cars.brands.BMW;
import com.github.nikznah.carfactory.cars.brands.Volvo;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.github.nikznah.carfactory.cars.Car.*;

public class Application {

    @SneakyThrows
    public static void main(String[] args) {

        File csvData = new File("src/main/resources/parce.csv");
        FileReader fileReader = new FileReader(csvData);
        try {
            CSVParser csvParser = CSVParser.parse(fileReader, CSVFormat.newFormat(';'));
            for (CSVRecord csvRecord : csvParser) {
                String brand = (csvRecord.get(0));
                String color = (csvRecord.get(1));
                int enginePower = Integer.parseInt((csvRecord.get(2)));
                String type = (csvRecord.get(3));
                boolean a1 = Boolean.parseBoolean((csvRecord.get(4)));
                boolean a2 = Boolean.parseBoolean((csvRecord.get(5)));
                initialize(brand, color, enginePower, type, a1, a2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initialize(String brand, String color, int enginePower, String type, boolean a1, boolean a2) {
        COLOR tmp;
        TYPE_ENGINE tmp2;
        if (color.equals(COLOR.RED.toString())) {
            tmp = COLOR.RED;
        } else if (color.equals(COLOR.GREEN.toString())) {
            tmp = COLOR.GREEN;
        } else if (color.equals(COLOR.BLUE.toString())) {
            tmp = COLOR.BLUE;
        } else {
            throw new IllegalArgumentException("Данного цвета нет в базе данных! " + color);
        }
        if (type.equals(TYPE_ENGINE.V8.toString())) {
            tmp2 = TYPE_ENGINE.V8;
        } else {
            tmp2 = TYPE_ENGINE.V12;
        }

        if (brand.equals(BRANDS.BMW.toString())) {
            Car car = new BMW(brand, tmp, enginePower, tmp2, a1, a2);
            car.CalculateFullPrice();
        } else if (brand.equals(BRANDS.Volvo.toString())) {
            Car car = new Volvo(brand, tmp, enginePower, tmp2, a1, a2);
            car.CalculateFullPrice();
        } else if (brand.equals(BRANDS.Audi.toString())) {
            Car car = new Audi(brand, tmp, enginePower, tmp2, a1, a2);
            car.CalculateFullPrice();
        } else {
            throw new IllegalArgumentException("Ошибка! данная марка автомабиля, не продается!");
        }

    }
}
