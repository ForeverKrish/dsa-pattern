# Two Sum

**Question:**
Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

**Explanation:**
Use a hashmap to store each number’s index. For each element, check if `target - currentValue` exists in the map. This yields O(n) time and O(n) space.