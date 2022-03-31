package com.epam.jwd.logic.reader;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile {

    private final static Logger logger = LogManager.getLogger(ReaderFromFile.class);

    public String read(String inputPath) throws IOException {
        logger.info("reader start read");
        StringBuilder textFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textFromFile.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            logger.error("IO exception", e);
            throw new IOException();
        }
        return textFromFile.toString();
    }

}
