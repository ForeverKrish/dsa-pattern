# Top K Frequent Elements

**Question:**
Return the `k` most frequent elements from an integer array.

**Explanation:**
Build a frequency map, then use a size-`k` min-heap to keep top frequencies. O(N log k) time, O(N) space.