package com.epam.jwd.logic.actions;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.paragraph.Text;
import com.epam.jwd.logic.parser.impl.TextParser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsByLengthRemove {
    private static final String WORD_DELETE_BY_LENGTH_START_REG_EX = "\\b\\w{";
    private static final String WORD_DELETE_BY_LENGTH_END_REG_EX = "}\\b";
    private static final String WORD_DELETE_REG_EX = "\\b";
    private static final char CHAR_A = 'a';
    private static final char CHAR_E = 'e';
    private static final char CHAR_I = 'i';
    private static final char CHAR_O = 'o';
    private static final char CHAR_U = 'u';
    private static final char CHAR_Z = 'z';
    private static final String REPLACEMENT = "";

    public Text removeWordsByLength(Text text, int length) {
        String regexToRemove = getRegex(length);
        String input = text.printText();
        Pattern pattern = Pattern.compile(regexToRemove, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        String output = input;
        while (matcher.find()) {
            if (isStartFromConsonant(matcher.group())) {
                StringBuilder sbRegex = new StringBuilder(WORD_DELETE_REG_EX);
                sbRegex.append(matcher.group());
                sbRegex.append(WORD_DELETE_REG_EX);
                output = output.replaceFirst(sbRegex.toString(), REPLACEMENT);
            }
        }
        TextParser parser = new TextParser();
        List<TextElement> textElements = parser.parse(output);
        return new Text(textElements);
    }

    private String getRegex(int length) {
        return new StringBuilder(WORD_DELETE_BY_LENGTH_START_REG_EX).append(length)
                .append(WORD_DELETE_BY_LENGTH_END_REG_EX)
                .toString();
    }

    private boolean isStartFromConsonant(String matcherGroup) {
        char firstChar = matcherGroup.toLowerCase().charAt(0);
        if (firstChar == CHAR_A
                || firstChar == CHAR_E
                || firstChar == CHAR_I
                || firstChar == CHAR_O
                || firstChar == CHAR_U) {
            return false;
        } else {
            return firstChar >= CHAR_A && firstChar <= CHAR_Z;
        }
    }

}
