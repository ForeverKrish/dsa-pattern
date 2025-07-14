# Merge Sorted Array

**Question:**
You have two sorted integer arrays, `nums1` and `nums2`, of sizes `m+n` and `n` respectively. The first `m` elements of `nums1` are valid; the rest are zeros. Merge `nums2` into `nums1` in-place so that `nums1` becomes a single sorted array.

**Explanation:**
Merge from the end to avoid overwriting in-place: compare the current largest of `nums1[0…m−1]` and `nums2[0…n−1]`, place the larger at the end of `nums1`, and decrement the corresponding pointer. Repeat until all of `nums2` is merged.