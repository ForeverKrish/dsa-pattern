package leetcode.hash_table;

import java.util.*;

/**
 * Top K Frequent Elements: Return k most frequent elements.
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // 1) Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // 2) Use a min-heap to keep the top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            // If heap grows larger than k, remove the least frequent
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 3) Extract keys from heap into result array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements finder = new TopKFrequentElements();
        // Example 1
        int[] result1 = finder.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        System.out.println("Top 2: " + Arrays.toString(result1)); // [1,2]
        // Example 2
        int[] result2 = finder.topKFrequent(new int[]{1}, 1);
        System.out.println("Top 1: " + Arrays.toString(result2)); // [1]
    }
}