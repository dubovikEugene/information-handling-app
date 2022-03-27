package com.epam.jwd.entity.codeblock;

import com.epam.jwd.entity.TextElement;

import java.util.List;

public class CodeBlock implements TextElement {
    private List<TextElement> codeElements;

    public CodeBlock(List<TextElement> codeElements) {
        this.codeElements = codeElements;
    }

    public List<TextElement> getCodeElements() {
        return codeElements;
    }

    public void setCodeElements(List<TextElement> codeElements) {
        this.codeElements = codeElements;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CodeBlock codeBlock = (CodeBlock) object;
        return this.codeElements.equals(codeBlock.codeElements);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime;
        result = result * prime * codeElements.hashCode();
        return result;
    }

    @Override
    public String printText() {
        return null;
    }
}
