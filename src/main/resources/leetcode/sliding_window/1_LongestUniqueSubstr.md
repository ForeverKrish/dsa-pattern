# Longest Substring Without Repeating Characters

**Question:**
Given a string `s`, find the length of the longest substring without repeating characters.

**Explanation:**
Use a sliding window `[start…end]`. Maintain `last[c]` as the last seen index+1 of character `c`. When encountering `s[end]`, if it appeared in the window, move `start` to `last[c]`. Update `maxLen` as window size, then set `last[c] = end+1`. O(n) time, O(1) space.