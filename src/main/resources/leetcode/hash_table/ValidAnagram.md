# Valid Anagram

**Question:**
Given two strings `s` and `t`, determine if `t` is an anagram of `s`.

**Explanation:**
Use a 26-element frequency array; increment for `s` and decrement for `t`. If all counts zero, they are anagrams. O(n) time, O(1) space.