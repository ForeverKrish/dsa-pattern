package leetcode.string_array;

import java.util.*;

public class PhoneNumberCombinations {

    // Map of digits to corresponding letters (like old mobile keypads)
    private static final Map<Character, String> keypadMap = new HashMap<>();

    static {
        keypadMap.put('0', "");     // No letters for 0
        keypadMap.put('1', "");     // No letters for 1
        keypadMap.put('2', "abc");
        keypadMap.put('3', "def");
        keypadMap.put('4', "ghi");
        keypadMap.put('5', "jkl");
        keypadMap.put('6', "mno");
        keypadMap.put('7', "pqrs");
        keypadMap.put('8', "tuv");
        keypadMap.put('9', "wxyz");
    }

    // Method to extract phone numbers from text (basic 10-digit pattern)
    public static List<String> extractPhoneNumbers(String text) {
        List<String> phoneNumbers = new ArrayList<>();
        String[] tokens = text.split("[^0-9]");
        for (String token : tokens) {
            if (token.length() == 10) {
                phoneNumbers.add(token);
            }
        }
        return phoneNumbers;
    }

    // Method to generate all combinations for a number
    public static List<String> generateCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    // Backtracking helper
    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = keypadMap.get(digits.charAt(index));

        if (letters.isEmpty()) {
            // Skip this digit if no letters are mapped (e.g., 0 or 1)
            backtrack(digits, index + 1, current, result);
        } else {
            for (char c : letters.toCharArray()) {
                current.append(c);
                backtrack(digits, index + 1, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        String inputText = "My numbers are 9876543210 and 9123456789. Call me maybe!";
        List<String> phoneNumbers = extractPhoneNumbers(inputText);

        for (String number : phoneNumbers) {
            System.out.println("Phone number: " + number);
            System.out.println("Combinations (showing first 10 only):");
            List<String> combinations = generateCombinations(number);
            for (int i = 0; i < Math.min(10, combinations.size()); i++) {
                System.out.println("  " + combinations.get(i));
            }
            System.out.println("Total combinations: " + combinations.size());
            System.out.println("--------");
        }
    }
}
