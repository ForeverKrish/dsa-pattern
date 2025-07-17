package leetcode.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubstr {

    public int lengthOfLongestSubstring(String s){
        int maxLength = 0;
        Set<Character> freqSet = new HashSet<>();

        int start = 0,end = 0;

        while(end<s.length()){
            //check the uniqueness of current character
            if(!freqSet.contains(s.charAt(end))){
                //new character in window
                freqSet.add(s.charAt(end));
                maxLength = Math.max(maxLength,end-start+1);
                end ++;
            }else{
                //duplicate : start removing from start until the reqd. duplicate is removed
                freqSet.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringMinimal(String s) {
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

        System.out.println(sol.lengthOfLongestSubstringMinimal("abcabcbb")); // Expect 3
        System.out.println(sol.lengthOfLongestSubstringMinimal("bbbbb"));    // Expect 1
        System.out.println(sol.lengthOfLongestSubstringMinimal(""));         // Expect 0
        System.out.println(sol.lengthOfLongestSubstringMinimal("pwwkew"));  // Expect 3
    }
}
/*
Time: O(n) — each character is visited once
Space: O(1) — fixed-size array of 128
* */