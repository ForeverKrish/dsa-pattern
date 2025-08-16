package leetcode.hash_table;

import java.util.*;

/**
 * Word Pattern: Check bijection between pattern and words.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Split string into words
        String[] words = s.split(" ");
        // Mismatch in lengths means no bijection
        if (pattern.length() != words.length) {
            return false;
        }
        // Map pattern character -> word
        Map<Character, String> charToWordMap = new HashMap<>();
        // Track used words to prevent multiple chars mapping to same word
        Set<String> usedWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String word = words[i];
            // If mapping exists, it must match current word
            if (charToWordMap.containsKey(patternChar)) {
                if (!charToWordMap.get(patternChar).equals(word)) {
                    return false;
                }
            } else {
                // New mapping: word must not be already used
                if (usedWords.contains(word)) {
                    return false;
                }
                charToWordMap.put(patternChar, word);
                usedWords.add(word);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern checker = new WordPattern();
        // Example 1
        System.out.println("abba, dog cat cat dog: " +
            checker.wordPattern("abba", "dog cat cat dog")
        ); // true
        // Example 2
        System.out.println("abba, dog cat cat fish: " +
            checker.wordPattern("abba", "dog cat cat fish")
        ); // false
    }
}