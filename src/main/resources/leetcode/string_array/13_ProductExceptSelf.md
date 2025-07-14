# Product of Array Except Self

**Question:**
Return an array where each element at index `i` is the product of all elements in the original array except `nums[i]`. Do it in O(n) without division.

**Explanation:**
First pass builds prefix products; second pass multiplies by suffix product tracked in a rolling variable.