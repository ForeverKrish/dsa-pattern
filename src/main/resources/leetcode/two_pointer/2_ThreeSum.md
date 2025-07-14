# 3Sum

**Question:**
Given an integer array `nums`, return all unique triplets `[a, b, c]` such that `a + b + c == 0`. The solution set must not contain duplicate triplets.

**Explanation:**
Sort the array. For each index `i`, use two pointers `lo` and `hi` to find pairs summing to `-nums[i]`. Skip duplicates for `i`, `lo`, and `hi` to ensure uniqueness. Overall O(n²) time.