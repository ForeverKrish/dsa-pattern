package leetcode.hash_table;

import java.util.*;

/**
 * Valid Anagram: Check if one string is an anagram of another.
 */
public class ValidAnagram {

    public boolean isAnagramUsingHashTable(String s, String t) {
        // If lengths differ, cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character,Integer> freqMap = new HashMap<>();
        int index = 0;

        while(index < s.length()){
            //Add each character freq from s
            freqMap.put(s.charAt(index),freqMap.getOrDefault(s.charAt(index),0)+1);

            //Remove each character freq from t
            freqMap.put(t.charAt(index),freqMap.getOrDefault(t.charAt(index),0)-1);
            index++;
        }

        //cleanup the freqMap
        Boolean anagramFlag = true;
        for (char key : freqMap.keySet()){
            if(freqMap.get(key) != 0){
                anagramFlag = false;
                break;
            }
        }

        return anagramFlag;
    }

    public boolean isAnagram(String s, String t) {
        // If lengths differ, cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        // Frequency array for each lowercase letter
        int[] letterFrequencies = new int[26];
        // Count letters in s and un-count in t
        for (int i = 0; i < s.length(); i++) {
            letterFrequencies[s.charAt(i) - 'a']++;
            letterFrequencies[t.charAt(i) - 'a']--;
        }
        // Verify all counts return to zero
        for (int count : letterFrequencies) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram checker = new ValidAnagram();
        // Example 1
        System.out.println("anagram/nagaram: " + checker.isAnagram("anagram", "nagaram")); // true
        // Example 2
        System.out.println("rat/car: " + checker.isAnagram("rat", "car"));               // false

        // Example 1
        System.out.println("anagram/nagaram: " + checker.isAnagramUsingHashTable("anagram", "nagaram")); // true
        // Example 2
        System.out.println("rat/car: " + checker.isAnagramUsingHashTable("rat", "car"));               // false
    }
}