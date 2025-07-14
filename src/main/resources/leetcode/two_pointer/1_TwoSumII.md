# Two Sum II – Input Array Is Sorted

**Question:**
Given a 1-indexed array of integers `numbers` sorted in non-decreasing order, find two numbers that add up to a specific target. Return their 1-based indices as `[i, j]`.

**Explanation:**
Use two pointers (`lo` at start, `hi` at end). Calculate `sum = numbers[lo] + numbers[hi]`. If `sum == target`, return `[lo+1, hi+1]`. If `sum < target`, increment `lo`; else decrement `hi`. Continues in O(n) time with O(1) space.