# Remove Duplicates from Sorted Array II

**Question:**
Given a sorted array `nums`, remove duplicates in-place allowing at most two occurrences of each element, and return the new length.

**Explanation:**
Copy each `num` if either we've written fewer than 2 elements total, or `num` differs from the element two positions back (`nums[write-2]`), ensuring no more than two duplicates.