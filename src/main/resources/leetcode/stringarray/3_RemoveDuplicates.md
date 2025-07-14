# Remove Duplicates from Sorted Array

**Question:**
Given a sorted array `nums`, remove duplicates in-place so each element appears only once, and return the new length.

**Explanation:**
Since the array is sorted, duplicates are adjacent. Keep a `write` pointer at the end of the unique portion; whenever `nums[read]` differs from its predecessor, copy it to `nums[write++]`.