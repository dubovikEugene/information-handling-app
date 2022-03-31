package com.epam.jwd.entity.codeblock;

import com.epam.jwd.entity.TextElement;

public class CodeElement implements TextElement {
    private String codeElement;

    public CodeElement(String codeElement) {
        this.codeElement = codeElement;
    }

    public String getCodeElement() {
        return codeElement;
    }

    public void setCodeElement(String codeElement) {
        this.codeElement = codeElement;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CodeElement that = (CodeElement) object;
        return this.codeElement.equals(that.codeElement);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result = result * prime * codeElement.hashCode();
        return result;
    }

    @Override
    public String printText() {
        return this.codeElement;
    }
}
