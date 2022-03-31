package com.epam.jwd.logic.actions;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.paragraph.Paragraph;
import com.epam.jwd.entity.paragraph.Sentence;
import com.epam.jwd.entity.paragraph.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UniqueWordFinder {

    public List<TextElement> findUniqueWord(Text text) {
        List<TextElement> textElements = text.getAllTextElements();

        List<TextElement> sentencesList = getListOfSentence(textElements);
        Sentence firstSentence = getFirstSentence(sentencesList);

        List<TextElement> wordsFromFirstSentence = firstSentence.getWords();
        List<TextElement> sentencesWithoutFirst = getSentencesListWithoutFirst(sentencesList);
        List<TextElement> wordsFromWholeSentencesWithoutFirst = sentencesWithoutFirst.stream()
                .filter(element -> element instanceof Sentence)
                .map(sentence -> ((Sentence) sentence).getWords())
                .flatMap(Collection::stream)
                .toList();

        List<TextElement> uniqueWords = new ArrayList<>();
        wordsFromFirstSentence.stream()
                .filter(word -> isHaveWord(word.printText(), wordsFromWholeSentencesWithoutFirst))
                .forEach(uniqueWords::add);


        return uniqueWords;

    }

    private boolean isHaveWord(String wordFromFirst, List<TextElement> wordsFromWholeSentencesWithoutFirst) {
        return wordsFromWholeSentencesWithoutFirst.stream()
                .noneMatch(word -> word.printText().toLowerCase().equals(wordFromFirst.toLowerCase()));
    }

    private List<TextElement> getListOfSentence(List<TextElement> textElements) {

        List<TextElement> sentences = textElements.stream()
                .filter(textElement -> textElement instanceof Paragraph)
                .map(sentence -> ((Paragraph) sentence).getSentences())
                .flatMap(Collection::stream)
                .toList();

        return sentences;
    }

    private Sentence getFirstSentence(List<TextElement> sentencesList) {
        return (Sentence) sentencesList.get(0);
    }

    private List<TextElement> getSentencesListWithoutFirst(List<TextElement> sentencesList) {
        List<TextElement> sentencesListWithoutFirst = new ArrayList<>(List.copyOf(sentencesList));
        sentencesListWithoutFirst.remove(0);
        return sentencesListWithoutFirst;
    }


}
