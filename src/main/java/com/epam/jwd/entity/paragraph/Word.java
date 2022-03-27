package com.epam.jwd.entity.paragraph;

import com.epam.jwd.entity.TextElement;

public class Word implements TextElement {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Word word1 = (Word) object;
        return this.word.equals(word1.getWord());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result = result * prime * word.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Word {" +
                "word ='" + word + '\'' +
                '}';
    }

    @Override
    public String printText() {
        return null;
    }
}
