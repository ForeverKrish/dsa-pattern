package leetcode.sliding_window;

import java.util.*;

public class MinWindow {

    public String minWindow(String s, String t) {
        int start = 0, end = 0, minWindowLen = Integer.MAX_VALUE;
        String minWindowSubSubstring = "";

        //1. map t
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        int requireMoreChars = tMap.keySet().size();

        //System.out.println(" requireMoreChars:"+requireMoreChars +" tMap" +tMap);

        while (end < s.length()){
            char currentCharacter = s.charAt(end);

            if(requireMoreChars > 0){
                //System.out.println("=======================");
                if(tMap.containsKey(currentCharacter)){
                    int currentFreq = tMap.get(currentCharacter) - 1;
                    tMap.put(currentCharacter,currentFreq);
                    if (currentFreq == 0){
                        requireMoreChars -- ;
                    }
                }
                end++;
                //System.out.println("currentCharacter:"+currentCharacter + " requireMoreChars:"+requireMoreChars +" tMap" +tMap+ " start:"+start+" end:"+end);
            }
            while(requireMoreChars == 0){
                //max length check
                if((end - start + 1) < minWindowLen){
                    minWindowSubSubstring = s.substring(start, end);
                }
                char startChar = s.charAt(start);
                if(tMap.containsKey(startChar)){
                    int currentFreq = tMap.get(startChar) + 1;
                    tMap.put(startChar,currentFreq);
                    if (currentFreq > 0){
                        requireMoreChars++;
                    }
                }
                start++;
                //System.out.println("startChar:"+startChar + " requireMoreChars:"+requireMoreChars +" tMap" +tMap+ " start:"+start+" end:"+end);
            }
        }

        return minWindowSubSubstring;

    }

    public String minWindowMinimal(String s, String t) {
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

        System.out.println(sol.minWindowMinimal("ADOBECODEBANC", "ABC")); // Expect "BANC"
        System.out.println(sol.minWindowMinimal("a", "a"));               // Expect "a"
        System.out.println(sol.minWindowMinimal("a", "aa"));              // Expect ""
    }
}