# Sort Colors

**Question:**
Given an array `nums` with values 0, 1, and 2, sort it in-place so that all 0s, then 1s, then 2s appear (red, white, blue). Use only constant extra space and one pass.

**Explanation:**
Use the Dutch National Flag algorithm with three pointers: `low` for 0s, `mid` for current, and `high` for 2s. Swap to partition into three regions in O(n) time, O(1) space.