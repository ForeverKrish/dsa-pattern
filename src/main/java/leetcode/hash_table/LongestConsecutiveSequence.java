package leetcode.hash_table;

import java.util.*;

/**
 * Longest Consecutive Sequence: Find length of longest run of consecutive numbers.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // Store unique numbers for O(1) lookups
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }
        int longestStreak = 0;
        // Only attempt to build sequences from numbers that are sequence starts
        for (int num : uniqueNumbers) {
            if (!uniqueNumbers.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // Incrementally check for consecutive numbers
                while (uniqueNumbers.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence seqFinder = new LongestConsecutiveSequence();
        // Example
        System.out.println("Sequence length: " +
            seqFinder.longestConsecutive(new int[]{100,4,200,1,3,2})
        ); // Expect 4
    }
}