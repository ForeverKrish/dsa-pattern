package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstr {

    public int lengthOfLongestSubstring(String s){
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        while(end < (s.length()-1)){
            char currentChar = s.charAt(end);
            map.put(currentChar,map.getOrDefault(currentChar,0)+1);

            //check unique
            while( (end - start + 1) > map.size() ){
                map.put(s.charAt(start),map.get(s.charAt(start)) - 1);
                if(map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }

            //update length of the longest subarray
            maxLen = Math.max(maxLen, (end - start + 1));
            end ++;

        }
        return maxLen;
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