package com.epam.jwd.logic.actions;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.paragraph.Paragraph;
import com.epam.jwd.entity.paragraph.Sentence;
import com.epam.jwd.entity.paragraph.Text;
import com.epam.jwd.entity.paragraph.Word;

import java.util.Collection;
import java.util.List;

public class WordsByLengthRemove {
    private static final String CONSONANTS = "[bBcCdDfFgGjJkKlLmMnNpPqQsStTvVxXzZhHrRwW]";

    public void removeWordsByLength(Text text, int length) {
        List<TextElement> textElements = text.getAllTextElements();

        textElements.stream()
                .filter(textElement -> textElement instanceof Paragraph)
                .map(paragraph -> ((Paragraph) paragraph).getSentences())
                .flatMap(Collection::stream)
                .filter(element -> element instanceof Sentence)
                .forEach(sentence -> removeWord((Sentence) sentence, length));
    }

    private void removeWord(Sentence sentence, int length){
        List<TextElement> words = sentence.getWords();
        List<TextElement> wordsAfterDelete = words.stream()
                .filter(word -> !isToRemove((Word) word, length))
                .toList();
        sentence.setWords(wordsAfterDelete);

    }

    private boolean isToRemove(Word word, int length) {
        return word.getWord().length() == length
                && CONSONANTS.indexOf(word.getWord().charAt(0)) != -1;
    }

}
