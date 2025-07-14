# 3Sum Closest

**Question:**
Given an integer array `nums` and an integer `target`, find three integers in `nums` such that their sum is closest to `target`. Return the sum of the three integers.

**Explanation:**
Sort `nums`. For each `i`, use two pointers `lo` and `hi` to scan for the closest sum to `target`, updating a running `closest` value. O(n²) time, O(1) extra space.