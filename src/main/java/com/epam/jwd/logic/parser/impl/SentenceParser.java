package com.epam.jwd.logic.parser.impl;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.paragraph.Word;
import com.epam.jwd.logic.parser.Parser;

import java.util.ArrayList;
import java.util.List;

//PArse sentence to words
public class SentenceParser implements Parser<String, List<TextElement>> {
    private static final String WORD_SPLIT_REG_EX = " ";

    @Override
    public List<TextElement> parse(String inputText) {
        String[] words = inputText.split(WORD_SPLIT_REG_EX);
        List<TextElement> wordsList = new ArrayList<>();
        for (String word : words) {
            wordsList.add(new Word(word));
        }
        return wordsList;
    }
}
