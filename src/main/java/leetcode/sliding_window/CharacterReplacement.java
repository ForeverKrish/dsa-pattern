package leetcode.sliding_window;

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, start = 0, result = 0;
        for (int end = 0; end < s.length(); end++) {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(end) - 'A']);
            if (end - start + 1 - maxFreq > k) {
                freq[s.charAt(start++) - 'A']--;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        CharacterReplacement sol = new CharacterReplacement();
        System.out.println(sol.characterReplacement("ABAB", 2));    // Expect 4
        System.out.println(sol.characterReplacement("AABABBA", 1)); // Expect 4
    }
}