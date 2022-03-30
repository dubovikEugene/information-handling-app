package com.epam.jwd;

import com.epam.jwd.entity.paragraph.Text;
import com.epam.jwd.logic.actions.PalindromeSubstringFinder;
import com.epam.jwd.logic.actions.UniqueWordFinder;
import com.epam.jwd.logic.actions.WordsByLengthRemove;
import com.epam.jwd.logic.parser.impl.TextParser;
import com.epam.jwd.logic.reader.ReaderFromFile;
import com.epam.jwd.logic.writer.WriterToFile;

import java.util.Optional;

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


        UniqueWordFinder uniqueWordFinder = new UniqueWordFinder();
        System.out.println(uniqueWordFinder.findUniqueWord(text));

        PalindromeSubstringFinder palindromeSubstring = new PalindromeSubstringFinder();
        Optional<String> palindrome = palindromeSubstring.getMaxLengthPalindromeSubstring(text);
        palindrome.ifPresent(System.out::println);

        WordsByLengthRemove wordsByLengthRemove = new WordsByLengthRemove();
        Text newText = wordsByLengthRemove.removeWordsByLength(text, 9);
        System.out.println(newText.printText());

    }
}
