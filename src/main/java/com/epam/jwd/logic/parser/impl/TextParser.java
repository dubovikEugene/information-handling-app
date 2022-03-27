package com.epam.jwd.logic.parser.impl;

import com.epam.jwd.entity.TextElement;
import com.epam.jwd.entity.codeblock.CodeBlock;
import com.epam.jwd.entity.paragraph.Paragraph;
import com.epam.jwd.logic.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Parse inputText to CodeBlocks and Paragraphs
public class TextParser implements Parser<String, List<TextElement>> {
    private static final String PARAGRAPH_REG_EX = "^(^[1-9].+)|([\\w \\p{Punct}]+)(\\.|:)$";
    private static final String CODE_BLOCK_END_REG_EX = "^\\}$|^[ ]+Grade = C$";


    @Override
    public List<TextElement> parse(String inputText) {

        Scanner scanner = new Scanner(inputText);

        List<String> tempTextBlocks = new ArrayList<>();
        String temp;
        StringBuilder codeBlockTemp = new StringBuilder();
        while (scanner.hasNextLine()) {
            temp = scanner.nextLine();
            if (temp.matches(PARAGRAPH_REG_EX)) {
                tempTextBlocks.add(temp);
            } else if (temp.matches(CODE_BLOCK_END_REG_EX)) {
                codeBlockTemp.append(temp);
                tempTextBlocks.add(codeBlockTemp.toString());
                codeBlockTemp.setLength(0);
            } else {
                codeBlockTemp.append(temp);
                codeBlockTemp.append(System.lineSeparator());
            }


        }

        ParagraphParser paragraphParser = new ParagraphParser();
        CodeBlockParser codeBlockParser = new CodeBlockParser();
        List<TextElement> textElements = new ArrayList<>();
        for (String elem : tempTextBlocks) {
            if (elem.matches(PARAGRAPH_REG_EX)) {
                List<TextElement> sentenceList = paragraphParser.parse(elem);
                textElements.add(new Paragraph(sentenceList));
            } else {
                List<TextElement> sentenceList = codeBlockParser.parse(elem);
                textElements.add(new CodeBlock(sentenceList));
            }
        }
        return textElements;
    }
}
