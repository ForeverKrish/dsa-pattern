# Longest Consecutive Sequence

**Question:**
Find the length of the longest sequence of consecutive integers in an unsorted array.

**Explanation:**
Store elements in a hash set. Only start counting when `num-1` not in set to ensure O(n) time.