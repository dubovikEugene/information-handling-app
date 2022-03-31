package com.epam.jwd.logic.writer;

import com.epam.jwd.logic.reader.ReaderFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterToFile {
    private static final String DELETE_FILE_FROM_PATH_REG_EX = "/[a-zA-Z_0-9]+\\.[a-zA-Z]{1,5}$";
    private static final String REPLACEMENT_REG_EX = "";
    private final static Logger logger = LogManager.getLogger(ReaderFromFile.class);

    public void write(String content, String outputPath) throws IOException {
        logger.info("writer start write");
        createDirectoryIsNotExist(outputPath);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            logger.error("IO exception", e);
            throw new IOException();
        }
    }

    private void createDirectoryIsNotExist(String path) throws IOException {
        String pathWithoutFile = deleteFileFromPath(path);
        Path pathOut = Paths.get(pathWithoutFile);
        if (isPathNotExist(pathOut)) {
            try {
                Files.createDirectories(pathOut);
            } catch (IOException e) {
                logger.error("IO exception", e);
                throw new IOException();
            }
        }

    }

    private boolean isPathNotExist(Path path) {
        return Files.notExists(path);
    }

    private String deleteFileFromPath(String path) {
        return path.replaceAll(DELETE_FILE_FROM_PATH_REG_EX, REPLACEMENT_REG_EX);
    }
}
