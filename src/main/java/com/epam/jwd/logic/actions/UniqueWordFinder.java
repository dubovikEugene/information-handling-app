package com.epam.jwd.logic.actions;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.paragraph.Paragraph;
import com.epam.jwd.entity.paragraph.Sentence;
import com.epam.jwd.entity.paragraph.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueWordFinder {
    private static final String WORD_REG_EX = "\\b";

    public String findUniqueWord(Text text) {
        List<String> words = getArrayWordsFromFirstSentence(text);
        String firstSentence = getFirstSentence(words);
        String textWithoutFirstSentence = getTextWithoutFirstSentence(text, firstSentence);

        List<String> regexList = getWordsRegex(words);
        Pattern pattern;
        for (String regex : regexList) {
            pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(textWithoutFirstSentence.toLowerCase());
            if (!matcher.find()) {
                matcher = pattern.matcher(firstSentence.toLowerCase());
                if (matcher.find()) {
                    return matcher.group();
                }
            }

        }
        throw new NoSuchElementException("do not have words");
    }

    private List<String> getArrayWordsFromFirstSentence(Text text) {
        List<TextElement> textElements = text.getAllTextElements();
        List<String> words = new ArrayList<>();
        for (TextElement textElement : textElements) {
            if (textElement.getClass().equals(Paragraph.class)) {
                List<TextElement> sentence = ((Paragraph) textElement).getSentences();
                TextElement element = sentence.get(0);
                if (element.getClass().equals(Sentence.class)) {
                    sentence = ((Sentence) element).getWords();
                    for (TextElement word : sentence) {
                        words.add(word.printText());
                    }
                }

            }
            break;
        }
        return words;
    }

    private String getFirstSentence(List<String> words) {
        StringBuilder firstSentence = new StringBuilder();
        for (String word : words) {
            firstSentence.append(word);
            firstSentence.append(" ");
        }
        firstSentence.deleteCharAt(firstSentence.length() - 1);
        return firstSentence.toString();
    }

    private String getTextWithoutFirstSentence(Text text, String firstSentence) {
        return text.printText().replaceFirst(firstSentence.toString(), "");
    }

    private List<String> getWordsRegex(List<String> words) {
        List<String> regexList = new ArrayList<>();
        StringBuilder sbRegex = new StringBuilder();
        for (String word : words) {
            sbRegex.insert(0, WORD_REG_EX)
                    .append(word.toLowerCase())
                    .append(WORD_REG_EX);
            regexList.add(sbRegex.toString());
            sbRegex.setLength(0);
        }
        return regexList;
    }
}
