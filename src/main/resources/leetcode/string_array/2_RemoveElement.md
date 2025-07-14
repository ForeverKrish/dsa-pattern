# Remove Element

**Question:**
Given an array `nums` and a value `val`, remove all occurrences of `val` in-place and return the new length. The relative order of other elements may change.

**Explanation:**
Use two pointers: `read` scans every element; `write` only advances when `nums[read]` ≠ `val`, copying valid elements forward. At end, `write` is the new length.