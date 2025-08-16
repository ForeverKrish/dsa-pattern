package leetcode.hash_table;

import java.util.*;

/**
 * Two Sum: Find two indices such that numbers add up to target.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Map to store number -> its index for quick complement lookup
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        // Iterate through the array
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentValue = nums[currentIndex];
            // Compute the needed complement to reach target
            int complement = target - currentValue;
            // If complement already exists in map, solution found
            if (numberToIndex.containsKey(complement)) {
                return new int[]{ numberToIndex.get(complement), currentIndex };
            }
            // Otherwise, record the current value with its index
            numberToIndex.put(currentValue, currentIndex);
        }
        // Given problem constraints, this line should never be reached
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        // Example 1
        int[] result1 = solver.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Result1: " + Arrays.toString(result1)); // Expect [0,1]
        // Example 2
        int[] result2 = solver.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Result2: " + Arrays.toString(result2)); // Expect [1,2]
    }
}

/**
 Time: O(n)
 Space: O(n)
 */