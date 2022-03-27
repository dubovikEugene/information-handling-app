package com.epam.jwd;

import com.epam.jwd.entity.paragraph.Text;
import com.epam.jwd.logic.parser.impl.TextParser;
import com.epam.jwd.logic.reader.ReaderFromFile;
import com.epam.jwd.logic.writer.WriterToFile;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input/text.txt";
    private static final String OUTPUT_PATH = "src/main/resources/output/text.txt";

    public static void main(String[] args) {
        ReaderFromFile readerFromFile = new ReaderFromFile();
        String readText = readerFromFile.read(INPUT_PATH);

        TextParser textParser = new TextParser();
        Text text = new Text(textParser.parse(readText));

        WriterToFile writer = new WriterToFile();
        writer.write(text.printText(), OUTPUT_PATH);


    }
}
