# Valid Sudoku

**Question:**
Determine if a 9×9 Sudoku board is valid. Empty cells are denoted by '.'. Each row, column, and 3×3 sub-box must contain no duplicate digits 1–9.

**Explanation:**
Use bitmasks for rows, columns, and boxes. For each filled cell, compute mask = 1<<(digit-1) and check/set the corresponding row, column, and box bit arrays. O(1) time and space.