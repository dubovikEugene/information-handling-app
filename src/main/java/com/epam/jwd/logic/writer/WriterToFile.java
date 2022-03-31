package com.epam.jwd.logic.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterToFile {
    private static final String DELETE_FILE_FROM_PATH_REG_EX = "/[a-zA-Z_0-9]+\\.[a-zA-Z]{1,5}$";
    private static final String REPLACEMENT_REG_EX = "";

    public void write(String content, String outputPath) {

        createDirectoryIsNotExist(outputPath);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));) {
            bufferedWriter.write(content);
        } catch (IOException e) {
//            TODO logger
            e.printStackTrace();
        }
    }

    private void createDirectoryIsNotExist(String path) {
        String pathWithoutFile = deleteFileFromPath(path);
        Path pathOut = Paths.get(pathWithoutFile);
        if (isPathNotExist(pathOut)) {
            try {
                Files.createDirectories(pathOut);
            } catch (IOException e) {
                e.printStackTrace();
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
