package com.epam.jwd.entity.paragraph;

import com.epam.jwd.entity.TextElement;

import java.util.List;

public class Text implements TextElement {
    private List<TextElement> allTextElements;

    public Text(List<TextElement> paragraphs) {
        this.allTextElements = paragraphs;
    }

    public void setParagraphs(List<TextElement> paragraphs) {
        this.allTextElements = paragraphs;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Text text = (Text) object;
        return this.allTextElements.equals(text.allTextElements);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result = result * prime * allTextElements.hashCode();
        return result;
    }

    @Override
    public String printText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextElement element : allTextElements) {
            stringBuilder.append(element.printText());
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
