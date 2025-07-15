# Minimum Size Subarray Sum

**Question:**
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a contiguous subarray of which the sum ≥ `target`. Return 0 if no such subarray exists.

**Explanation:**
Expand the window by moving `end`, accumulating `sum`. While `sum ≥ target`, update `minLen` and shrink from the left. O(n) time, O(1) space.