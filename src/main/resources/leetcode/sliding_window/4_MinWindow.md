# Minimum Window Substring

**Question:**
Given strings `s` and `t`, return the minimum window in `s` containing all characters of `t`. If none, return `""`.

**Explanation:**
Build a `need` table for `t`. Slide `end` over `s`, decrementing `need[c]` and reducing `missing`. When `missing == 0`, try shrinking from `start` to find the smallest valid window, updating `minLen` and `minStart`. O(n + m) time, O(1) space.