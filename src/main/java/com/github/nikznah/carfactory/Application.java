package com.github.nikznah.carfactory;

import com.github.nikznah.carfactory.calc.Calculator;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

                Calculator calculator = new Calculator();
                calculator.CalculateFullPrice(brand, color, enginePower, type, a1, a2);

                Order order = new Order();
                order.putOrder(brand, color, enginePower, type, a1, a2);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
