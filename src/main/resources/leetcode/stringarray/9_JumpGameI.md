# Jump Game

**Question:**
Given non-negative `nums`, start at index 0; at each step you can jump up to `nums[i]`. Return whether you can reach the last index.

**Explanation:**
Maintain the farthest index reachable. If at any point `i > reach`, you’re stuck; otherwise update `reach`.