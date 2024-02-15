package com.pars.csv;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvParser {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/oleksandrstepurko/IdeaProjects/HillelJavaWinter2024/mvnProjects/pars/src/main/resources/username.csv";

        List<UEmail> lines = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(UEmail.class)
                .withSeparator(',')
                .build()
                .parse();

        lines.forEach(System.out::println);
    }
}
