# Game of Life

**Question:**
Given an m×n board of live (1) and dead (0) cells, update to the next state using the rules of Conway’s Game of Life, in-place.

**Explanation:**
Encode the next state in the 2nd bit of each cell. First pass computes live neighbor counts and sets bit 1 if cell becomes live. Second pass shifts all values right by 1 to update states. O(m×n) time, O(1) space.