package leetcode.hash_table;

import java.util.*;

/**
 * Subarray Sum Equals K: Count subarrays summing to k.
 */
public class SubarraySumEqualsK {

    public int subarraySumSlidingWindow(int[] nums, int k) {
        int totalSubarrays = 0, start = 0, end = 0, sum = 0;
        boolean shrinkFlag = false;

        while (end < nums.length){
            if(shrinkFlag != true){
                sum = sum + nums[end];
            }

            if(sum > k){
                //reduce the window
                while (start<=end && sum > k){
                    sum = sum - nums[start];
                    start ++;
                }
                shrinkFlag = true;
            }else if(sum == k){
                totalSubarrays++; //found sub-array
                end++; //move towards finding the next window
                shrinkFlag = false;
            }else {
                end++; //if sum < k : increase the window
                shrinkFlag = false;
            }
        }

        return totalSubarrays;
    }

    public int subarraySum(int[] nums, int k) {
        // Map prefix sum -> count of occurrences
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Initialize with sum 0 having one occurrence
        prefixSumCounts.put(0, 1);
        int runningSum = 0;
        int count = 0;
        // Iterate through array, updating running sum
        for (int value : nums) {
            runningSum += value;
            // If (runningSum - k) exists, there are subarrays ending here summing to k
            count += prefixSumCounts.getOrDefault(runningSum - k, 0);
            // Record this running sum
            prefixSumCounts.put(runningSum,
                prefixSumCounts.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK counter = new SubarraySumEqualsK();
        // Example: [1,1,1], k=2 yields 2 subarrays ([1,1] twice)
        System.out.println("Count: " +
            counter.subarraySum(new int[]{1,1,1}, 2)
        ); // Expect 2

        System.out.println("Count: " +
                counter.subarraySumSlidingWindow(new int[]{1,1,1}, 2)
        );
    }
}