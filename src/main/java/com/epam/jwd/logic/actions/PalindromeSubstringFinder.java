package com.epam.jwd.logic.actions;

import com.epam.jwd.entity.paragraph.Text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PalindromeSubstringFinder {

    public Optional<String> getMaxLengthPalindromeSubstring(Text text) {
        List<String> palindromes = getAllPalindromes(text.printText());

        return palindromes.stream()
                .max(Comparator.comparingInt(String::length));
    }

    private List<String> getAllPalindromes(String input) {
        List<String> palindromes = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (isPalindrome(input.substring(i, j))) {
                    if (!input.substring(i, j).isBlank()) {
                        palindromes.add(input.substring(i, j));
                    }
                }
            }
        }

        return palindromes;
    }

    private boolean isPalindrome(String input) {
        StringBuilder inputString = new StringBuilder(input);
        StringBuilder reverseInputString = inputString.reverse();
        return (reverseInputString.toString().equals(input));
    }

}
