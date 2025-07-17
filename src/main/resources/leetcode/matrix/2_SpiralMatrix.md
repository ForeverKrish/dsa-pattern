# Spiral Matrix

**Question:**
Given an m×n matrix, return all elements in spiral order (clockwise).

**Explanation:**
Maintain boundaries top, bottom, left, right and traverse in four directions, updating boundaries after each side. Collect values until all are visited. O(m×n) time.