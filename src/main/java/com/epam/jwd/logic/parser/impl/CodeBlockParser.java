package com.epam.jwd.logic.parser.impl;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.codeblock.CodeElement;
import com.epam.jwd.logic.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class CodeBlockParser implements Parser<String, List<TextElement>> {
    private static final String CODE_ELEMENT_SPLIT_REG_EX = "";

    @Override
    public List<TextElement> parse(String inputString) {
        String[] codeElementsArray = inputString.split(CODE_ELEMENT_SPLIT_REG_EX);
        List<TextElement> listCodeElements = new ArrayList<>();
        for (String codeElement : codeElementsArray) {
            listCodeElements.add(new CodeElement(codeElement));
        }

        return listCodeElements;
    }

}
