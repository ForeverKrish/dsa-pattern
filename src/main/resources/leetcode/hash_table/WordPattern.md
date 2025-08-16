# Word Pattern

**Question:**
Determine if a pattern string and a sentence of words follow a bijection mapping.

**Explanation:**
Maintain a map from pattern char to word and a set of used words. Ensure consistency in both directions. O(n) time, O(n) space.