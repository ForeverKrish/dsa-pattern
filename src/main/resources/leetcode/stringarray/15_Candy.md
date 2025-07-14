# Candy

**Question:**
N children in a line with ratings; give candies so that each child has at least one, and higher-rated children get more candies than neighbors. Minimize total candies.

**Explanation:**
First pass ensures left neighbor rule; second pass fixes any right neighbor violations, taking the max to respect both sides.