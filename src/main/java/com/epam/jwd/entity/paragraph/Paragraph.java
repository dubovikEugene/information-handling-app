package com.epam.jwd.entity.paragraph;

import com.epam.jwd.entity.TextElement;

import java.util.List;

public class Paragraph implements TextElement {
    private List<TextElement> sentences;

    public Paragraph(List<TextElement> sentences) {
        this.sentences = sentences;
    }

    public List<TextElement> getSentences() {
        return sentences;
    }

    public void setSentences(List<TextElement> sentences) {
        this.sentences = sentences;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Paragraph paragraph = (Paragraph) object;
        return this.sentences.equals(paragraph.getSentences());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result = result * prime * sentences.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Paragraph {" +
                "sentences =" + sentences +
                '}';
    }

    @Override
    public String printText() {
        final String sentencesDelimiter = " ";
        StringBuilder stringBuilder = new StringBuilder();
        for (TextElement sentence : sentences) {
            stringBuilder.append(sentence.printText())
                    .append(sentencesDelimiter);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
