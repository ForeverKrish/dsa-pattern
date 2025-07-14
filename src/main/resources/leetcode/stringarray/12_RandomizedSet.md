# Insert Delete GetRandom O(1)

**Question:**
Implement a data structure supporting `insert`, `remove`, and `getRandom` in average O(1) time.

**Explanation:**
Use a list for O(1) random access and a map from value→index for O(1) lookup and swaps on removal.