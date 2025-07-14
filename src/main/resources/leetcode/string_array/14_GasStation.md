# Gas Station

**Question:**
Given `gas` and `cost` arrays, find the starting station index to complete a circuit once, or return −1.

**Explanation:**
If you run negative (`tank < 0`), that segment cannot be a valid tour; reset and try from `i+1`. If overall net gas ≥ 0, start works.