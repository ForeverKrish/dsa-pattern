# Subarray Sum Equals K

**Question:**
Count the number of continuous subarrays whose sum equals `k`.

**Explanation:**
Use a prefix sum and a hashmap to count occurrences of `(currentSum - k)`. O(n) time, O(n) space.