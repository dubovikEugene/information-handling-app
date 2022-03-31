package com.epam.jwd;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.paragraph.Text;
import com.epam.jwd.logic.actions.PalindromeSubstringFinder;
import com.epam.jwd.logic.actions.UniqueWordFinder;
import com.epam.jwd.logic.actions.WordsByLengthRemove;
import com.epam.jwd.logic.parser.impl.TextParser;
import com.epam.jwd.logic.reader.ReaderFromFile;
import com.epam.jwd.logic.writer.WriterToFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input/text.txt";
    private static final String MAIN_OUTPUT_PATH = "src/main/resources/output/text.txt";
    private static final String TASK_3_OUTPUT_PATH = "src/main/resources/output/task_3.txt";
    private static final String TASK_12_OUTPUT_PATH = "src/main/resources/output/task_12.txt";
    private static final String TASK_14_OUTPUT_PATH = "src/main/resources/output/task_14.txt";
    private final static Logger logger = LogManager.getLogger(ReaderFromFile.class);

    public static void main(String[] args) {
        ReaderFromFile readerFromFile = new ReaderFromFile();
        String readText = readerFromFile.read(INPUT_PATH);

        TextParser textParser = new TextParser();
        Text text = new Text(textParser.parse(readText));

        WriterToFile writer = new WriterToFile();
        try {
            writer.write(text.printText(), MAIN_OUTPUT_PATH);
        } catch (IOException e) {
            logger.error("IO exception", e);
        }


        UniqueWordFinder uniqueWordFinder = new UniqueWordFinder();
        List<TextElement> uniqueWord = uniqueWordFinder.findUniqueWord(text);
        try {
            writer.write(uniqueWord.toString(), TASK_3_OUTPUT_PATH);
        } catch (IOException e) {
            logger.error("IO exception", e);
        }

        PalindromeSubstringFinder palindromeSubstring = new PalindromeSubstringFinder();
        Optional<String> palindrome = palindromeSubstring.getMaxLengthPalindromeSubstring(text);
        try {
            writer.write(palindrome.toString(), TASK_14_OUTPUT_PATH);
        } catch (IOException e) {
            logger.error("IO exception", e);
        }

        WordsByLengthRemove wordsByLengthRemove = new WordsByLengthRemove();
        wordsByLengthRemove.removeWordsByLength(text, 9);
        try {
            writer.write(text.printText(), TASK_12_OUTPUT_PATH);
        } catch (IOException e) {
            logger.error("IO exception", e);
        }

    }
}
