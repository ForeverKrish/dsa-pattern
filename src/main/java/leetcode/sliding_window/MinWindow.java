package leetcode.sliding_window;

import java.util.*;

public class MinWindow {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int missing = t.length(), start = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        for (int end = 0; end < s.length(); end++) {
            if (need[s.charAt(end)]-- > 0) missing--;
            while (missing == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                if (need[s.charAt(start)]++ == 0) missing++;
                start++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinWindow sol = new MinWindow();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // Expect "BANC"
        System.out.println(sol.minWindow("a", "a"));               // Expect "a"
        System.out.println(sol.minWindow("a", "aa"));              // Expect ""
    }
}