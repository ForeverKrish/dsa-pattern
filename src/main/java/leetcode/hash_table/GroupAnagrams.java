package leetcode.hash_table;

import java.util.*;

/**
 * Group Anagrams: Group words that are anagrams.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagramsHashTable(String[] words) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> anagramMap = new HashMap<>();

        for(String word: words){
            //sort the word and add it to the map sortedword,actualWordList
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            if(anagramMap.containsKey(key)){
                List<String> list = anagramMap.get(key);
                list.add(word);
                anagramMap.put(key,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                anagramMap.put(key,list);
            }
        }

        //parse through the map and add the group anagram list
        for(String key: anagramMap.keySet()){
            result.add(anagramMap.get(key));
        }
        return result;

    }

    public List<List<String>> groupAnagrams(String[] words) {
        // Map sorted character key -> list of anagrams
        Map<String, List<String>> sortedKeyToGroup = new HashMap<>();
        // Process each word
        for (String word : words) {
            // Convert word to character array and sort to form key
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);
            // Add word to corresponding anagram group
            sortedKeyToGroup
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(word);
        }
        // Return grouped anagrams
        return new ArrayList<>(sortedKeyToGroup.values());
    }

    public static void main(String[] args) {
        GroupAnagrams grouper = new GroupAnagrams();
        List<List<String>> groups = grouper.groupAnagrams(
            new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        );
        System.out.println("Anagram groups: " + groups);
        // Examples: [["eat","tea","ate"],["tan","nat"],["bat"]]

        List<List<String>> groups2 = grouper.groupAnagramsHashTable(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        );
        System.out.println("Anagram groups: " + groups2);
        // Examples: [["eat","tea","ate"],["tan","nat"],["bat"]]
    }
}