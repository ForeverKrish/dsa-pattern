# Longest Repeating Character Replacement

**Question:**
Given a string `s` and an integer `k`, you can replace any character at most `k` times. Return the length of the longest substring containing the same letter after at most `k` replacements.

**Explanation:**
Slide `[start…end]` over `s`, track `freq` counts and `maxFreq` in the window. If window size minus `maxFreq` exceeds `k`, shrink from the left. Update `result` at each step. O(n) time, O(1) space.