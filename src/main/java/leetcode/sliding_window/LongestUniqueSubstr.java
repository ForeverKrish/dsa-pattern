package leetcode.sliding_window;

public class LongestUniqueSubstr {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int start = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            start = Math.max(start, last[s.charAt(end)]);
            maxLen = Math.max(maxLen, end - start + 1);
            last[s.charAt(end)] = end + 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestUniqueSubstr sol = new LongestUniqueSubstr();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // Expect 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // Expect 1
        System.out.println(sol.lengthOfLongestSubstring(""));         // Expect 0
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));  // Expect 3
    }
}
/*
Time: O(n) — each character is visited once
Space: O(1) — fixed-size array of 128
* */