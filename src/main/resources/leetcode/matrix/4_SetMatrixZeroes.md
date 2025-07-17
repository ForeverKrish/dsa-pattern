# Set Matrix Zeroes

**Question:**
If an element in an m×n matrix is 0, set its entire row and column to 0 in-place.

**Explanation:**
Use the first row and column as markers. First pass sets markers when zeros are found. Second pass (bottom-up) zeroes cells based on markers, handling the first column separately. O(m×n) time, O(1) space.