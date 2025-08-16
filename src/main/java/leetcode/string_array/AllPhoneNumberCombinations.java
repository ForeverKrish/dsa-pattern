package leetcode.string_array;

import java.util.*;

public class AllPhoneNumberCombinations {

    // Keypad mapping
    private static final Map<Character, String> keypadMap = new HashMap<>();
    static {
        keypadMap.put('0', ""); // No mapping
        keypadMap.put('1', ""); // No mapping
        keypadMap.put('2', "abc");
        keypadMap.put('3', "def");
        keypadMap.put('4', "ghi");
        keypadMap.put('5', "jkl");
        keypadMap.put('6', "mno");
        keypadMap.put('7', "pqrs");
        keypadMap.put('8', "tuv");
        keypadMap.put('9', "wxyz");
    }

    // Generate all combinations for a single number
    public static List<String> generateCombinations(String number) {
        List<String> result = new ArrayList<>();
        backtrack(number, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String number, int index, StringBuilder current, List<String> result) {
        if (index == number.length()) {
            result.add(current.toString());
            return;
        }

        char digit = number.charAt(index);
        String letters = keypadMap.get(digit);
        if (letters.isEmpty()) {
            // Skip 0 or 1
            backtrack(number, index + 1, current, result);
        } else {
            for (char c : letters.toCharArray()) {
                current.append(c);
                backtrack(number, index + 1, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Set how many phone numbers you want to generate
        long maxCount = 10000; // ⚠️ Limit to avoid huge computation
        long startNumber = 0;

        for (long i = startNumber; i < startNumber + maxCount; i++) {
            String phoneNumber = String.format("%010d", i);
            System.out.println("📱 Phone Number: " + phoneNumber);

            List<String> combinations = generateCombinations(phoneNumber);

            System.out.println("🔡 Combinations (first 10):");
            for (int j = 0; j < Math.min(1000, combinations.size()); j++) {
                System.out.println("  " + combinations.get(j));
            }
            System.out.println("🔢 Total combinations: " + combinations.size());
            System.out.println("---------------------------------------------------");
        }
    }
}
