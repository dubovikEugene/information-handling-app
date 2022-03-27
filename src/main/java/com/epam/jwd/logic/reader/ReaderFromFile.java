package com.epam.jwd.logic.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile {

    public String read(String inputPath) {

        StringBuilder textFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
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
