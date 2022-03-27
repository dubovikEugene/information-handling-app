package com.epam.jwd.entity.paragraph;

import com.epam.jwd.entity.TextElement;

import java.util.List;

public class Sentence implements TextElement {
    private List<TextElement> words;

    public List<TextElement> getWords() {
        return words;
    }

    public Sentence(List<TextElement> words) {
        this.words = words;
    }

    public void setWords(List<TextElement> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Sentence sentence = (Sentence) object;
        return this.words.equals(sentence.getWords());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result = result * prime * words.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sentence {" +
                " words =" + words +
                '}';
    }

    @Override
    public String printText() {
        final String wordsDelimiter = " ";
        StringBuilder stringBuilder = new StringBuilder();
        for (TextElement word : words) {
            stringBuilder.append(word.printText())
                    .append(wordsDelimiter);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
