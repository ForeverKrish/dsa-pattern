package leetcode.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, maxWindow = 0, maxFreqency = 0;
        Map<Character,Integer> map = new HashMap<>();
        if(s.length() == 0){
            return 0;
        }


        while(end < s.length()){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);

            //find valid window
            int windowLength = end - start + 1;
            maxFreqency = Math.max(maxFreqency,map.get(s.charAt(end)));

            //case window exceeds condition - shrik window from start
            if(windowLength - maxFreqency  > k){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }

            //compare window size
            windowLength = end - start + 1;
            maxWindow = Math.max(maxWindow,windowLength);

            //increment window
            end++;
        }
        return maxWindow;
    }

    public int characterReplacementMinimal(String s, int k) {
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

        System.out.println(sol.characterReplacementMinimal("ABAB", 2));    // Expect 4
        System.out.println(sol.characterReplacementMinimal("AABABBA", 1)); // Expect 4
    }
}