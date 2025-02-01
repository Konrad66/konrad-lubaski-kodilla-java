package com.kodilla.testing;

import java.util.Set;

public class VowelFinder {

    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y');

    private String findVowels(String text) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (vowels.contains(ch)) {
                newText.append(ch);
            }
        }
        return newText.toString();
    }
}