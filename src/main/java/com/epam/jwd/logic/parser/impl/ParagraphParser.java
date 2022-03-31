package com.epam.jwd.logic.parser.impl;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.paragraph.Sentence;
import com.epam.jwd.logic.parser.Parser;

import java.util.ArrayList;
import java.util.List;

//Parse paragraphs to sentences
public class ParagraphParser implements Parser<String, List<TextElement>> {
    private static final String SENTENCE_REGEX = "(?<=[a-z0])\\.";

    @Override
    public List<TextElement> parse(String inputText) {
        String[] sentences = inputText.split(SENTENCE_REGEX);

        List<TextElement> listSentence = new ArrayList<>();
        SentenceParser sentenceParser = new SentenceParser();
        for (String sentence : sentences) {
            List<TextElement> wordsList = sentenceParser.parse(sentence);
            listSentence.add(new Sentence(wordsList));
        }

        return listSentence;
    }
}
