package com.epam.jwd.logic.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile {
    private static final String OUTPUT_PATH = "src/main/resources/input/text.txt";

    public String read() {

        StringBuilder textFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textFromFile.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
//            TODO logger
            e.printStackTrace();
        }
        return textFromFile.toString();
    }

}
